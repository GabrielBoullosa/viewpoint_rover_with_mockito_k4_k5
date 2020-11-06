package refactoring;

public interface ViewPoint {

    void forward();

    void backward();

    void turnLeft();

    void turnRight();

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position forward(Heading heading) {
            if(heading == Heading.North) y++;
            if(heading == Heading.South) y--;
            if(heading == Heading.East) x++;
            if(heading == Heading.West) x--;
            return this;
        }

        public Position backward(Heading heading) {
            return forward(oposite(heading));
        }

        public Heading oposite(Heading heading) {
            return heading.turnLeft().turnLeft();
        }

        @Override
        public boolean equals(Object object) {
            return isSameClass(object) && equals((Position) object);
        }

        private boolean equals(Position position) {
            return position == this || (x == position.x && y == position.y);
        }

        private boolean isSameClass(Object object) {
            return object != null && object.getClass() == Position.class;
        }

    }


    public enum Heading {
        North, East, South, West;

        public static Heading of(String label) {
            return of(label.charAt(0));
        }

        public static Heading of(char label) {
            if (label == 'N') return North;
            if (label == 'S') return South;
            if (label == 'W') return West;
            if (label == 'E') return East;
            return null;
        }

        public Heading turnRight() {
            return values()[add(+1)];
        }

        public Heading turnLeft() {
            return values()[add(-1)];
        }

        private int add(int offset) {
            return (this.ordinal() + offset + values().length) % values().length;
        }

    }
}
