package com.dev.mendes.android_mytasks.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tainaviriato on 21/06/17.
 */

public class DataBaseControl {

    private SQLiteDatabase db;
    private DataBaseTask banco;

    public DataBaseControl(Context context) {
        banco = new DataBaseTask(context);
    }

    public String addTask(String taskName, String taskDate, String taskPlace, String taskNote) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataBaseTask.NOME, taskName);
        valores.put(DataBaseTask.DATE, taskDate);
        valores.put(DataBaseTask.PLACE, taskPlace);
        valores.put(DataBaseTask.NOTE, taskNote);

        resultado = db.insert(DataBaseTask.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao adicionar tarefa";
        } else {
            return "Tarefa adicionada com sucesso";
        }

    }

    public Cursor loadTasks() {
        Cursor cursor;
        String[] campos = {banco.ID, banco.NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


}
