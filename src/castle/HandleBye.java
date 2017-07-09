package castle;

public class HandleBye extends Handler{

	public HandleBye(Game game) {
		super(game);
	}

	@Override
	public boolean isBye()
	{
		return true;
	}
}
