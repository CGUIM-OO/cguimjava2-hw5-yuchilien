import java.util.ArrayList;
import java.util.Random;

/**
 * Description: TODO: 
 * 	�ΰj�鲣�ͩҦ����P�A��iArrayList
 * 	�j��Ĥ@�h:�@���X�ƵPdeck �j��ĤG�h:���t���suit �j��ĤT�h:���t�I��rank
 * 	�~�P�G���P�_�P�O�_���ιL�A�����ܴN���[�^�h�A���H�����@�i�P�P�Y��m���P�洫
 * 	�o�P�G�Y�O���}���P�|�S�O�O���_�ӡA�C�i�o�X�h���P���|�O���A�P�o���F�|����~�P
 * 
 */
public class Deck {
	private ArrayList<Card> cards;// �{�b�P���W���P
	private ArrayList<Card> usedCards;// �s�o�L���P
	private ArrayList<Card> openCard;//�s�񦹰ƵP���Ҧ����}���P�A�~�P�ɭn���m
	public int nUsed;// �O���o�L�X�i�P


	public Deck(int nDeck) {
		//��l�Ƴo��ArrayList
		cards = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		// �`�@���X�ƵP�N����
		for (int i = 0; i < nDeck; i++) {
			// ������� 
			for (Card.Suit s : Card.Suit.values()) {
				
				// �����I��(1~13)
				for (int r = 1; r < 14; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}

		}
		shuffle();
	}

	// �@�~�T �G�~�P
	public void shuffle() {
		// �p�G�P���ιL
		if(usedCards.size() != 0)
		{
			// ��ιL���P�[�^�h
			for(Card c : usedCards)
			{
				cards.add(c);
			}
			// ��ιL���P�M��
			usedCards.clear();
			nUsed = 0;
		}
		
		Random rnd = new Random();
		// i�O�{�b�n�B�z���P
		for (int i = 0; i < cards.size(); i++) {
			// j�O�H���b�Ҧ�cards�����@�i�P
			int j = rnd.nextInt(cards.size());
			// ���i�i���O���_��
			Card tmp = cards.get(i);
			// ��j�i�����i�i����m
			cards.set(i, cards.get(j));
			// ��i�i�����j�i����m
			cards.set(j, tmp);
		}
	}

	// �@�~�|�A�o�P�ק�(�[�JisOpened�ѼơA�M�w�o�X�h���P�O�}���٬O�\�_�Ӫ�)
	public Card getOneCard (boolean isOpened) {
		// ���X�b�Ĥ@�Ӧ�m���P
		Card c = cards.get(0);
		//�Y�O�}�۪��P�A�[�JopenCard
		if(isOpened) {
			openCard.add(c);
		}
		
		// ��o�i�P�O���_��
		
		usedCards.add(c);
		// �O���h�o�F�@�i�P
		nUsed++;
		// ��o�i�P�R��
		cards.remove(c);
		// �p�G�P�o���F
		if (cards.size() == 0) {
			// ���s����~�Pmethod
			shuffle();
		}
		// �^�ǳo�i�P
		return c;
	}

	
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		
		// �L�X�P���W�Ҧ����P
		for (Card i : cards)// for each
		{
			i.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}
