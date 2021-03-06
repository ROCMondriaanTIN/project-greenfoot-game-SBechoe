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
                tile = new Platform("grass.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 4:
                tile = new Platform("grassCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 5:
                tile = new Platform("grassLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                //tile.getImage().mirrorVertically();
                tile.isSolid = true;
                break;
            case 6:
                tile = new Platform("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 7:
                tile = new Platform("grassRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 8:
                tile = new Platform("grassCliffLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 9:
                tile = new Platform("grassCliffRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 10:
                tile = new Platform("grassHalf.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 11:
                tile = new Platform("grassHalfLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 12:
                tile = new Platform("grassHalfMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 13:
                tile = new Platform("grassHalfRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 14:
                tile = new Platform("grassHillLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 15:
                tile = new Platform("grassHillLeft2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 16:
                tile = new Platform("grassHillRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 17:
                tile = new Platform("grassHillRight2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
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
                tile.getImage().rotate(90);
                break;
            case 26:
                tile = new Tile("cactus.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 27:
                tile = new Tile("bush.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 28:
                tile = new Tile("grassCliffLeftAlt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 29:
                tile = new Tile("grassCliffRightAlt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            default:
                tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
        }
        return tile;
    }
}
