import java.util.ArrayList;
/**
 * Description: 
 * 	�o�OPlayer���O(�~�ӤFPerson���O)
 * field�G�m�W�B���a�����w�X�B���a�����U�`�w�X�B���a�������쪺�P
 * method�G�^�Ǫ��a�W�r�B�U�`�B�]�w�o�쪱�a���P���ұo�쪺�d(�s��oneRoundCard ArrayList)�B
 * 	�O�_�n�P(�P�_�ۤv�ثe�I���`�M�A16�I�H�U�n�P�A17�I�H�W���n�P)�B
 * 	���P���ۤv�ұo���P�I���`�M(�[�`oneRoundCard�̭����I�ơAJQK����10�I)�B
 * 	�^�Ǫ��a�{���w�X�B���a�w�X�ܰʡB���aSay Hello
 */
public class Player extends Person{

	private String name;// ���a�m�W
	private int chips;// ���a�������w�X
	private int bet;// ���a�����U�`���w�X
	//�~��private ArrayList<Card> oneRoundCard;// ���a���P�����쪺�P

	// Player constructor
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}

	//�^�Ǫ��a�W�r
	public String getName() {
		return name;
	}

	// �U�`
	public int makeBet() {
		// �ˬd�w�X�O�_���s
		if (chips != 0) {
			bet = bet;
		}
		// �S�w�X�F�N����A�~��U�`
		else {
			bet = 0;
		}
		
		return bet;
	}
	
	// �]�w�o�쪱�a���P���ұo�쪺�d 
//	�~��public void setOneRoundCard(ArrayList<Card> cards) {
//		oneRoundCard=cards;
//	}
	
	// �O�_�n�P
	
	@Override
	public  boolean hit_me(Table table) {
		boolean hit;// �n�P�^��true�A���A�n�P�h�^��false
		
		int myCardSum = getTotalValue();// ���ۤv�ثe���I���`�M�ӧP�_
		
		// 16�I�H�U�n�P�A17�I�H�W���n�P
		if(myCardSum <= 16)
		{
			hit = true;
		}
		else {
			hit = false;
		}
		
		return hit;
	}
	// ���P���ۤv�ұo���P�I���`�M
//	�~��public int getTotalValue() {
//		int myCardSum = 0;
//		
//		for(Card c : oneRoundCard) 
//		{
//			if(c.getRank()<10) 
//			{
//				myCardSum += c.getRank();
//			}
//			//J,Q,K����10
//			else {
//				myCardSum += 10;
//			}
//		}
//		return myCardSum;
//	}
	
	// �^�Ǫ��a�{���w�X
	public int getCurrentChips() {
		return chips;
	}
	
	// ���a�w�X�ܰ�
	public void increaseChips (int diff) {	
		bet = diff;
	}
	
	// ���aSay Hello
	public void sayHello() {
		
		System.out.println("Hello, I am " + name + ".");
	    System.out.println("I have " + chips + " chips.");
	}
}
