    public enum Direction {
        NORTH("North"), EAST("East"), SOUTH("South"), WEST("West");
    
        private final String namn;
        Direction(String namn) {this.namn = namn;}
    
        @Override
        public String toString() {return namn;}

        public double[] toPosition() {
            switch(this) {
                case NORTH: return new double[] {0, 1};
                case EAST: return new double[] {1, 0};
                case SOUTH: return new double[] {0, -1};
                case WEST: return new double[] {-1, 0};
                default: throw new IllegalArgumentException("Unknown direction: " + this);
            }
        }

        public Direction turnLeft() {
            switch(this) {
                case NORTH: return WEST;
                case WEST: return SOUTH;
                case SOUTH: return EAST;
                case EAST: return NORTH;
                default: throw new IllegalArgumentException("Unknown direction: " + this);
            }
        }

        public Direction turnRight() {
            switch(this) {
                case NORTH: return EAST;
                case EAST: return SOUTH;
                case SOUTH: return WEST;
                case WEST: return NORTH;
                default: throw new IllegalArgumentException("Unknown direction: " + this);
            }
        }
    }