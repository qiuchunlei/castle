package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();
        
    public Game() 
    {
        createRooms();
        handlers.put("go", new HandlerGo(this));
        handlers.put("bye", new HandleBye(this));
        handlers.put("help", new HandleHelp(this));
        handlers.put("tips", new HandleTips(this));
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom, hole;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        hole = new Room("陷阱", new Description() {
			@Override
			public String getDescription() {
				// TODO 自动生成的方法存根
				return "你掉进了陷进，出不去了";
			}
			
			@Override
			public String getTips() {
				return "出不去了，说再见吧";
			}
		});
        
        //	初始化房间的出口
        outside.setExits("south", lobby);
        outside.setExits("east", study);
        outside.setExits("west", pub);
        outside.setExits("down", hole);
        lobby.setExits("nouth", outside);
        pub.setExits("east", outside);
        study.setExits("west", outside);
        study.setExits("south", bedroom);
        bedroom.setExits("nouth", study);
        hole.setExits("up", hole);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getNextRoom(direction);

        if (nextRoom == null) {
            System.out.println("那里没有门！");
            //showPrompt();
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
    
    public void showPrompt()
    {
    	String sExitDesc;
        System.out.println("你在：" + currentRoom);
        if (currentRoom.hasDescription())
        {
        	System.out.println(currentRoom.getDescription());
        }
        
        sExitDesc = currentRoom.getExitDesc();
        if (sExitDesc.equals("") == false)
        {
        	System.out.print("出口有: " + sExitDesc);
        }
        System.out.println();
    }
    
    public String getTips()
    {
    	return currentRoom.getTips();
    }
    
    public void play()
    {
		Scanner in = new Scanner(System.in);
        while ( true ) {
        	String cmd = in.next();
        	Handler handler;
	        handler = handlers.get(cmd);
	        if (handler != null)
	        {
	        	if (handler.isBye())
	        	{
	        		break;
	        	}
	        	handler.doCmd(in.nextLine().trim());
	        }
	        else
	        {
	        	System.out.println("无效的命令");
	        }
        }
        in.close();
    }
	
	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
        game.play();
        System.out.println("感谢您的光临。再见！");
	}

}
