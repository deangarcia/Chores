
public enum Room 
{
	LIVINGROOM (0, "Living Room"),
    KITCHEN   (1, "Kitchen"),
    DINNINGROOM   (2, "Dinning Room"),
    BATHROOM    (3, "Bathroom"),
    GRANDMASBATHROOM (4,   "Grandparent's Bathroom"),
    HALLWAY (5, "Hallway"),
    FRONTYARD  (6, "Front Yard"),
    BACKYARD (7, "Back yard"),
	POOL (8,   "Pool"),
    VEHICLES (9, "Vehicles"),
    PATIO  (10, "Patio"),
    DOGSROOM (11, "Dog's Room");

    private final int mSheet;   // in kilograms
    private final String mName; // in meters
    
    Room(int sheet, String name) 
    {
        mSheet = sheet;
        mName = name;
    }
    public int getSheet() { return mSheet; }
    public  String getName() { return mName; }
}
