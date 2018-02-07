package com.adino.mta.data;

import android.provider.BaseColumns;

/**
 * Created by afadinsro on 1/10/18.
 */

public final class Contract {
    private Contract() {}

    public static class FlameEntry implements BaseColumns{
        public static final String TABLE_NAME = "flame";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NUM_BRANCHES = "numBranches";
        public static final String COLUMN_IMG_URL = "imgUrl";
    }

    public static class MemberEntry implements BaseColumns{
        public static final String TABLE_NAME = "member";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMG_URL = "imgUrl";
        // TODO add other variables
    }

    public static class BacentaEntry implements BaseColumns{
        public static final String TABLE_NAME = "bacenta";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMG_URL = "imgUrl";
        // TODO add other variables
    }

    public static class CenterEntry implements BaseColumns{
        public static final String TABLE_NAME = "center";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMG_URL = "imgUrl";
        // TODO add other variables
    }
}
