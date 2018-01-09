package com.adino.mta.enums;

/**
 * Created by afadinsro on 12/27/17.
 */

public enum Ministry {
    GREATER_LOVE{
        @Override
        public String toString() {
            return "Greater Love Choir";
        }
    },
    DANCING_STARS{
        @Override
        public String toString() {
            return "Dancing Stars";
        }
    },
    FILM_STARS{
        @Override
        public String toString() {
            return "Film Stars";
        }
    },
    COMMUNION_STARS{
        @Override
        public String toString() {
            return "Communion Stars";
        }
    },
    AIRPORT_STARS{
        @Override
        public String toString() {
            return "Airport Stars";
        }
    },
    STILL_PHOTOGRAPHY{
        @Override
        public String toString() {
            return "Still Photography";
        }
    },
    SOUND{
        @Override
        public String toString() {
            return "Sound";
        }
    },
    PROJECTION{
        @Override
        public String toString() {
            return "Projection";
        }
    },
    WEBSITE{
        @Override
        public String toString() {
            return "Website";
        }
    },
    MUSICIANS{
        @Override
        public String toString() {
            return "Musicians";
        }
    },
    DEFAULT{
        @Override
        public String toString() {
            return "Default";
        }
    }
}
