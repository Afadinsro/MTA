package com.adino.mta.enums;

/**
 * Created by afadinsro on 12/17/17.
 */

public enum Day {
    SUNDAY {
        @Override
        public String toString() {
            return "Sunday";
        }
    },
    MONDAY{
        @Override
        public String toString() {
            return "Monday";
        }
    },
    TUESDAY{
        @Override
        public String toString() {
            return "Tuesday";
        }
    },
    WEDNESDAY{
        @Override
        public String toString() {
            return "Wednesday";
        }
    },
    THURSDAY{
        @Override
        public String toString() {
            return "Thursday";
        }
    },
    FRIDAY{
        @Override
        public String toString() {
            return "Friday";
        }
    },
    SATURDAY{
        @Override
        public String toString() {
            return "Saturday";
        }
    }
}
