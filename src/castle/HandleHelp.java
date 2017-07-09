package castle;

public class HandleHelp extends Handler{

	public HandleHelp(Game game) {
		super(game);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void doCmd(String cmd) {
        System.out.print("迷路了吗？你可以做的命令有：go bye help tips ");
        System.out.println("如：\tgo east");
	}
}
