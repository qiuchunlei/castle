package castle;

public class HandleTips extends Handler{

	public HandleTips(Game game)
	{
		super(game);
	}
	
	@Override
	public void doCmd(String cmd)
	{
		// TODO �Զ����ɵķ������
		System.out.println("Tips:" + game.getTips());
	}
}
