package castle;

public class HandleHelp extends Handler{

	public HandleHelp(Game game) {
		super(game);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void doCmd(String cmd) {
        System.out.print("��·������������������У�go bye help tips ");
        System.out.println("�磺\tgo east");
	}
}
