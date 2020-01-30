package com.adn.adnalquilerparqueadero.infraestructura.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    val MIGRATION_5_6: Migration = object : Migration(5, 6) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE `alquilerEspacio` ADD COLUMN nickName TEXT NOT NULL DEFAULT ''"
            )
        }
    }
}