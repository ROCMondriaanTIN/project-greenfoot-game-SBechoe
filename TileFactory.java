/**
 *
 * @author R. Springer
 */
public class TileFactory {

    /**
     * Creates a Tile object based on the mapIcon number you give
     *
     * @param mapIcon number
     * @return Tile tile object
     */
    public Tile createTile(int mapIcon) {
        Tile tile;
        switch (mapIcon) {
            case 1:
                tile = new Tile("liquidWaterTop_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 2:
                tile = new WaterTile("liquidWater.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 3:
                tile = new Tile("grass.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 4:
                tile = new Tile("grassCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 5:
                tile = new Tile("grassLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                //tile.getImage().mirrorVertically();
                tile.isSolid = true;
                break;
            case 6:
                tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 7:
                tile = new Tile("grassRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 8:
                tile = new Tile("grassCliffLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 9:
                tile = new Tile("grassCliffRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 10:
                tile = new Tile("grassHalf.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 11:
                tile = new Tile("grassHalfLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 12:
                tile = new Tile("grassHalfMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 13:
                tile = new Tile("grassHalfRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 14:
                tile = new Tile("grassHillLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 15:
                tile = new Tile("grassHillLeft2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 16:
                tile = new Tile("grassHillRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 17:
                tile = new Tile("grassHillRight2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 18:
                tile = new Tile("door_closedMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 19:
                tile = new Tile("door_closedTop.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 20:
                tile = new Tile("mushroomBrown.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 21:
                tile = new Tile("mushroomRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 22:
                tile = new Tile("plant.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 23:
                tile = new Tile("signRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 24:
                tile = new Tile("signLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 25:
                tile = new Spikes("spikes.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 26:
                tile = new Tile("cactus.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 27:
                tile = new Tile("bush.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            default:
                tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
        }
        return tile;
    }
}
