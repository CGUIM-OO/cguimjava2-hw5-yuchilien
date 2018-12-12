/**
 * Description: TODO: 
 * suit�O���,rank�O�I�� �إ߳o����ݩ� �٦��غc�l
 * 	�ഫ�Ʀr�N�X�P���M�I�ƪ��^��W�r
 * 
 */
public class Card {
	public enum Suit{Spade,Heart,Diamond,Clubs}// �C�|���
	private Suit suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4 �����i�H�O����
	private int rank; // 1~13
	
	/**
	 * @param s suit���
	 * @param r rank�I��
	 */
	// Constructor
	public Card(Suit s, int value) {
		suit = s;
		rank = value;
	}

	
	public  void printCard() {
		
		//�إߨ��String�ܼƨӦs�ഫ�᪺�^��W�r
		String sString="";//�s���
		String rString="";//�s�I��ToString(suit)
		
		// ���Ӫ��,�Ʀr1~4���O���������,�P�_�O�X���A�s�JsString
		switch(suit)
		{
			case Clubs:
				sString ="Club";
				break;
			case Diamond:
				sString = "Diamond";
				break;
			case Heart:
				sString = "Heart";
				break;
			case Spade:
				sString = "Spade";
				break;
		}

		// �����I��,1�B11�B12�B13�I���O���^��W�r�ҥH�n���ഫ�A�s�JrString
		switch(rank)
		{
			case 1:
				rString ="Ace";
				break;
			case 11:
				rString = "Jack";
				break;
			case 12:
				rString = "Queen";
				break;
			case 13:
				rString = "King";
				break;
		
			default:
				rString = Integer.toString(rank);
				break;
		}
		// �L�X�P�������I��
		System.out.println(sString + "," + rString);
	
	}

	public Suit getSuit() {// return type�O�C�|������
		return suit;
	}

	public int getRank() {
		return rank;
	}
}

