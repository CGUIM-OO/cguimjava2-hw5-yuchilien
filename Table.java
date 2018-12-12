import java.util.ArrayList;

public class Table {

	public final int MAXPLAYER = 4; // �̦h�@�i�P��৤�X�ӤH
	public Deck allCard; // �s��Ҧ����P
	public Player[] allPlayer; // �s��Ҧ������a
	public Dealer aDealer; // �s��@�Ӳ��a
	public int[] pos_betArray; // �s��C�Ӫ��a�b�@���U���`

	// Constructor
	public Table(int nDeck) {

		Deck oneDeck = new Deck(nDeck); // Deck class�����
		allCard = oneDeck; // �æs�J�W�z�s�W��Deck�ܼ�
		allPlayer = new Player[MAXPLAYER]; // ��l��Player[]

	}

	// �NPlayer���P��(�Y�Ӧ�m��Y�ӤH)
	public void set_player(int pos, Player p) {

		allPlayer[pos] = p;

	}

	// �^�ǩҦ��b�P��W��player
	public Player[] get_player() {

		return allPlayer;

	}

	// �NDealer���P��W
	public void set_dealer(Dealer d) {

		aDealer = d;
	}

	// �^��dealer���}�����i�P�A�]�N�O�ĤG�i�P
	public Card get_face_up_card_of_dealer() {

		return allCard.getOneCard(true);

	}

	private void ask_each_player_about_bets() {

		// �C�Ӫ��a���۩I
		for (Player i : allPlayer) {
			i.sayHello();
		}

		// �C�Ӫ��a�U�`�A�s�bpos_betArray
		for (int i = 0; i <= MAXPLAYER; i++) {
			pos_betArray[i] = allPlayer[i].makeBet();
		}
	}

	//�o�P�����a����a�A���o��i���}���P�����a
	private void distribute_cards_to_dealer_and_players() {
		
		aDealer.setOneRoundCard(allCard.getOneCard(true));
		
	}

	//�ݨC�Ӫ��a�n���n�P
	private void ask_each_player_about_hits(Player[] allP) {
		int i;
		//�̧Ǹ߰ݨC�@��a
		for (Player i : allPlayer) {
			boolean hit = false;
			do {
				hit = allP[i].hit_me(null); // this
				if (hit) {
					player1Card.add(deck.getOneCard(true));
					allP[i].setOneRoundCard(player1Card);
					System.out.print("Hit! ");
					System.out.println(allP[0].getName() + "'s Cards now:");
					for (Card c : player1Card) {
						c.printCard();
					}
				} else {
					System.out.println(allP[i].getName() + ", Pass hit!");
					System.out.println(allP[i].getName() + ", Final Card:");
					for (Card c : player1Card) {
						c.printCard();
					}
				}
			} while (hit);
		}

	}
	
	// �߰ݲ��a�O�_�n�P
	private void ask_dealer_about_hits() {
		boolean hit;
		//�@�w�|���ݤ@���n���n
	    do
	    {
	    ArrayList<Card> cards = aDealer.getOneRoundCard();
	      hit = aDealer.hit_me(null);
	      if (hit)
	      {
	        cards.add(allCard.getOneCard(true));
	        aDealer.setOneRoundCard(cards);
	      }
	      if (aDealer.getTotalValue() > 21) {
	        hit = false;
	      }
	      //�p�G�٦��n�P�N�n�A�~���
	    } while (hit);
	    System.out.println("Dealer's hit is over!");
	}
	
	private void calculate_chips() {
		//�L�X���a���I�ƩM�P
		int aDealerCardValue = aDealer.getTotalValue();
		System.out.print("Dealer's card value is " + aDealerCardValue + " ,Cards:");
		aDealer.printAllCard();
		
	}
	


	public void play() {
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits(allPlayer);
		ask_dealer_about_hits();
		calculate_chips();

	}

	public int[] get_palyers_bet() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
