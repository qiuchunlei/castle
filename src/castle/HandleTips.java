package castle;

public class HandleTips extends Handler{

	public HandleTips(Game game)
	{
		super(game);
	}
	
	@Override
	public void doCmd(String cmd)
	{
		// TODO 自动生成的方法存根
		System.out.println("Tips:" + game.getTips());
	}
}
