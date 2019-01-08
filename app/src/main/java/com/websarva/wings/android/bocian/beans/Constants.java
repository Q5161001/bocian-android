package com.websarva.wings.android.bocian.beans;

// 名前付き定数クラス、ユーザに見せない内部的な定数はここで定義する
// また、レイアウトに使用しない数字などの国際的に通用する文字もここで定義する
public final class Constants {

    // データベース
    public final class DB {
        // データベース名
        public static final String DBName = "Bocian.db";
        // データベースバージョン
        public static final int VERSION = 1;
        // データベーステーブル名
        public static final String tableAdministrator = "Administrator";
        public static final String tableCompany = "Company";
        public static final String tableConferenceEquipment = "ConferenceEquipment";
        public static final String tableConferenceRoom = "ConferenceRoom";
        public static final String tableDepartment = "Department";
        public static final String tableEmployee = "Employee";
        public static final String tableEquipment = "Equipment";
        public static final String tableExternalParticipant = "ExternalParticipant";
        public static final String tableInParticipant = "InParticipant";
        public static final String tablePosition = "Position";
        public static final String tablePurpose = "Purpose";
        public static final String tableReserve = "Reserve";
        public static final String tableRgularMeeting = "RgularMeeting";
        public static final String tableTemporaryReserve = "TemporaryReserve";
        public static final String tableTerminal = "Terminal";
    }
    private Constants (){}

}
