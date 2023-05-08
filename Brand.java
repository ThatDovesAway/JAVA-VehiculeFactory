public class Brand {

    private final String name;
    private final Country country;

    public Brand(final String name, final Country country) {
        this.name = name;
        this.country = country;
    }

    protected enum Country {
        FRANCE, USA, GERMANY, ITALIE, JAPAN;

        @Override
        public String toString() {
            return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
        }
    }

    public String toString() {
        return this.name + " based on " + this.country;
    }
}