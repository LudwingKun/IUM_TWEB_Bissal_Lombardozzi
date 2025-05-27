package com.bissallombardozzi.springbootserver.Dto;

import java.util.List;
import java.util.Map;

public class OscarEditionInfo {
        private int edition;
        private int year;
        private int numberOfWinners;

        public int getEdition() {
            return edition;
        }

        public void setEdition(int edition) {
            this.edition = edition;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getNumberOfWinners() {
            return numberOfWinners;
        }

        public void setNumberOfWinners(int numberOfWinners) {
            this.numberOfWinners = numberOfWinners;
        }

    }

