package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start () {
        bombMap = new Matrix(Box.ZERO);
        for(int j = 0; j < totalBombs; j++) {
            placeBomb();
        }
    }

    private void placeBomb () {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord, Box.BOMB);
        incNumdersAroundBomb(coord);

    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void incNumdersAroundBomb(Coord coord) {
        for (Coord arround : Ranges.getCoordsAround(coord)) {
            if (Box.BOMB != bombMap.get(arround)) {
                bombMap.set(arround, bombMap.get(arround).nextNumberBox());

            }
        }
    }

}
