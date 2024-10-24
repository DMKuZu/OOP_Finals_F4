package elements.blessing;


public interface List_of_Blessings {

    enum Legendary {
        BLESS1("Blessing of Vitality", "HP", 100),
        BLESS2("Blessing of Might", "ATK", 80),
        BLESS3("Blessing of Fortitude", "DEF", 80),
        BLESS4("Blessing of Agility", "DODGE", 30),
        BLESS5("Blessing of Precision", "CRIT", 20);

        private final String name;
        private final String stat;
        private final int value;

        Legendary(String name, String stat, int value) {
            this.name = name;
            this.stat = stat;
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public String getStat() {
            return stat;
        }
        public int getValue() {
            return value;
        }
    }

    enum Epic {
        BLESS1("Benediction of Vigor", "HP", 80),
        BLESS2("Benediction of Prowess", "ATK", 70),
        BLESS3("Benediction of Resilience", "DEF", 60),
        BLESS4("Benediction of Swiftness", "DODGE", 22),
        BLESS5("Benediction of Mastery", "CRIT", 17),
        BLESS6("Benediction of Vitality","HP",50),
        BLESS7("Benediction of Impact", "ATK", 55),
        BLESS8("Benediction of Fortitude", "DEF", 50),
        BLESS9("Benediction of Reflexes", "DODGE", 20),
        BLESS10("Benediction of Accuracy", "CRIT", 16);

        private final String name;
        private final String stat;
        private final int value;

        Epic(String name, String stat, int value) {
            this.name = name;
            this.stat = stat;
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public String getStat() {
            return stat;
        }
        public int getValue() {
            return value;
        }
    }

    enum Rare {
        BLESS1("Boon of Endurance", "HP", 60),
        BLESS2("Boon of Strength", "ATK", 50),
        BLESS3("Boon of Hardiness", "DEF", 45),
        BLESS4("Boon of Agility", "DODGE", 19),
        BLESS5("Boon of Precision", "CRIT", 15),
        BLESS6("Boon of Vitality","HP",40),
        BLESS7("Boon of Impact", "ATK", 45),
        BLESS8("Boon of Fortitude", "DEF", 40),
        BLESS9("Boon of Reflexes", "DODGE", 18),
        BLESS10("Boon of Accuracy", "CRIT", 14);

        private final String name;
        private final String stat;
        private final int value;

        Rare(String name, String stat, int value) {
            this.name = name;
            this.stat = stat;
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public String getStat() {
            return stat;
        }
        public int getValue() {
            return value;
        }
    }

    enum Uncommon {
        BLESS1("Charm of Vitality", "HP", 50),
        BLESS2("Charm of Prowess", "ATK", 40),
        BLESS3("Charm of Resilience", "DEF", 35),
        BLESS4("Charm of Swiftness", "DODGE", 16),
        BLESS5("Charm of Mastery", "CRIT", 12),
        BLESS6("Charm of Vitality","HP",30),
        BLESS7("Charm of Impact", "ATK", 35),
        BLESS8("Charm of Fortitude", "DEF", 30),
        BLESS9("Charm of Reflexes", "DODGE", 12),
        BLESS10("Charm of Accuracy", "CRIT", 10);

        private final String name;
        private final String stat;
        private final int value;

        Uncommon(String name, String stat, int value) {
            this.name = name;
            this.stat = stat;
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public String getStat() {
            return stat;
        }
        public int getValue() {
            return value;
        }
    }

    enum Common {
        BLESS1("Gift of Endurance","HP",40),
        BLESS2("Gift of Strength", "ATK", 30),
        BLESS3("Gift of Hardiness", "DEF", 24),
        BLESS4("Gift of Agility", "DODGE", 12),
        BLESS5("Gift of Precision", "CRIT", 8),
        BLESS6("Gift of Vitality","HP",30),
        BLESS7("Gift of Impact", "ATK", 25),
        BLESS8("Gift of Fortitude", "DEF", 20),
        BLESS9("Gift of Reflexes", "DODGE", 10),
        BLESS10("Gift of Accuracy", "CRIT", 6);

        private final String name;
        private final String stat;
        private final int value;

        Common(String name, String statType, int statValue) {
            this.name = name;
            this.stat = statType;
            this.value = statValue;
        }

        public String getName() {
            return name;
        }
        public String getStat() {
            return stat;
        }
        public int getValue() {
            return value;
        }
    }

}
