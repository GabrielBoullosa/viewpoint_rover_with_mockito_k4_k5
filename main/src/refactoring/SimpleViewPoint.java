package refactoring;

public class SimpleViewPoint implements ViewPoint {
    private Position position;
    private Heading heading;

    public SimpleViewPoint(String facing, int x, int y){
        heading = Heading.of(facing);
        position = new Position(x, y);

    }

    public SimpleViewPoint(Heading heading, int x, int y){
        this.heading = heading;
        position = new Position(x, y);
    }

    public SimpleViewPoint(Heading heading, Position position) {
        this.heading = heading;
        this.position = position;
    }

    @Override
    public ViewPoint forward() {
        position = position.forward(heading);
        return this;
    }

    @Override
    public ViewPoint backward() {
        position = position.backward(heading);
        return this;
    }

    @Override
    public ViewPoint turnLeft() {
        heading = heading.turnLeft();
        return this;
    }

    @Override
    public ViewPoint turnRight() {
        heading = heading.turnRight();
        return this;
    }

    public Position position() {
        return position;
    }

    public Heading heading() {
        return heading;
    }

    public static enum Heading {
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

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position forward(Heading heading) {
            if (heading == Heading.North) y++;
            if (heading == Heading.South) y--;
            if (heading == Heading.East) x++;
            if (heading == Heading.West) x--;
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
}
