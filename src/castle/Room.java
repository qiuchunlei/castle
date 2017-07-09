package castle;

import java.util.HashMap;

public class Room {
    private String roomName;
    private Description description;
    private HashMap<String, Room> exitRooms = new HashMap<String, Room>();

    public Room(String rooName) 
    {
        this.roomName = rooName;
    }
    
    public Room(String roomName, Description description)
    {
    	this.roomName = roomName;
    	this.description = description;
    }

    public void setExits(String description, Room room) 
    {
        exitRooms.put(description, room);
    }

    @Override
    public String toString()
    {
        return roomName;
    }
    
    public String getExitDesc()
    {
    	StringBuffer str = new StringBuffer();
    	for (String s: exitRooms.keySet())
    	{
    		str.append(s);
    		str.append(" ");
    	}
    	return str.toString();
    }
    
    public Room getNextRoom(String description)
    {
        return exitRooms.get(description);
    }
    
    public boolean hasDescription()
    {
    	if (this.description == null)
    		return false;
    	return true;
    }
    
    public String getDescription()
    {
    	return description.getDescription();
    }
    
    public String getTips()
    {
    	if (description == null)
    		return "当前房间没有建议，你可以试试go [" + getExitDesc() + "]";
    	return description.getTips();
    }
}
