import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class Algorithm {
	
	JTable tableAI = new JTable();
	public static int moves = 0; 
	public int gameCounter;
	
	public Algorithm(JTable table1, int gameCounterImp){
	tableAI = table1;
	gameCounter = gameCounterImp;
	}
	
	public void defend(int x, int y){
		
		if(gameCounter % 2 == 0){
			if(moves == 1){
				if((x == 1) && (y == 1)){
					tableAI.setValueAt("O", 0, 0);
					moves++;
					System.out.println("AI Move 2:" + moves);
				}else{
					tableAI.setValueAt("O", 1, 1);
					moves++;
					System.out.println("AI Move 2:" + moves);
				}
			}
						
			if(moves == 3){
				if(cornerPlacement(x, y)){
					
					if((x == 0 && y == 2)){					
						tableAI.setValueAt("O", 2, 0);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}else if((x == 2 && y == 2)){
						attack(x, y, 1);
						System.out.println("AI WINS");
					}else{
						tableAI.setValueAt("O", 0, 2);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}
					
				}
				if(crossPlacement(x,y)){
					if((x == 0 && y == 1)){					
						tableAI.setValueAt("O", 2, 1);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}else if((x == 1 && y == 0)){
						tableAI.setValueAt("O", 1, 2);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}else if((x == 1 && y == 2)){
						tableAI.setValueAt("O", 1, 0);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}else{
						tableAI.setValueAt("O", 0, 1);
						moves++;
						System.out.println("AI Move 4:" + moves);
					}
				}
		    }
			if(moves == 5){
				if(cornerPlacement(x,y)){
					if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X") &&  y != 0 && tableAI.getValueAt(0, 1) != "X"){
						attack(x,y,2);
					}else if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X") &&  x == 1 && y == 0){
						tableAI.setValueAt("O", 1, 2);
					}else if(tableAI.getValueAt(1, 1) ==  "X" && (tableAI.getValueAt(2, 0) == "X" || tableAI.getValueAt(2, 2) == "X") && tableAI.getValueAt(1, 0) != "O" && tableAI.getValueAt(0,1)!= "X" && tableAI.getValueAt(1, 2) != "O"){
						attack(x,y,3);
					}else if((tableAI.getValueAt(1, 1) == "X" && (tableAI.getValueAt(2, 0) == "X" || tableAI.getValueAt(2, 2) == "X")) &&  x == 0 && y == 1){
						tableAI.setValueAt("O", 2, 1);
					}
					if((tableAI.getValueAt(1, 1) ==  "X" && tableAI.getValueAt(1, 2) == "X") && tableAI.getValueAt(1,0) == "O"){
						attack(x,y,4);
					}
					if(tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(2, 1) == "X" && tableAI.getValueAt(0, 1) == "O"){
						attack(x,y,5);
					}
					if(tableAI.getValueAt(0, 1) == "X" && tableAI.getValueAt(2, 1) == "O" && tableAI.getValueAt(1, 1) == "X"){
						moves++;
						tableAI.setValueAt("O", 2, 0);
					}
					if(tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(1, 0) == "X" && tableAI.getValueAt(1, 2) == "O" && x == 2 && y == 0){
						tableAI.setValueAt("O", 0, 2);
					}
				}
				if(crossPlacement(x,y)){
					if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X") &&  y != 0){
						attack(x,y,2);
					}else if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X") &&  x == 1 && y == 0){
						tableAI.setValueAt("O", 1, 2);
					}else if(tableAI.getValueAt(1, 1) ==  "X" && (tableAI.getValueAt(2, 0) == "X" || tableAI.getValueAt(2, 2) == "X") && x != 0){
						attack(x,y,3);
					}else if((tableAI.getValueAt(1, 1) == "X" && (tableAI.getValueAt(2, 0) == "X" || tableAI.getValueAt(2, 2) == "X")) &&  x == 0 && y == 1){
						tableAI.setValueAt("O", 2, 1);
					}
					if((tableAI.getValueAt(1, 1) ==  "X" && tableAI.getValueAt(1, 2) == "X") && tableAI.getValueAt(1, 0) == "O"){
						attack(x,y,4);
					}
					if(tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(2, 1) == "X" && tableAI.getValueAt(0, 1) == "O"){
						attack(x,y,5);
					}
					if(tableAI.getValueAt(0, 1) == "X" && tableAI.getValueAt(2, 1) == "O" && x == 1 && y == 2){
						moves++;
						tableAI.setValueAt("O", 1, 0);
					}
					if(tableAI.getValueAt(0, 1) == "X" && tableAI.getValueAt(2, 1) == "O" && x == 0 && y == 2){
						moves++;
						tableAI.setValueAt("O", 1, 2);
					}
					if(tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(1, 0) == "X" && tableAI.getValueAt(1, 2) == "O" && x != 1 && y != 2){
						attack(x,y,6);
					}
					
				}
				/*if(cornerPlacement(x, y)){
					if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X") && x != 1 && y != 0){
						
						attack(x,y,2);
					//if((tableAI.getValueAt(0, 2) == "X" && tableAI.getValueAt(2, 2) == "X") && tableAI.getValueAt(1, 1) == "X"){					
						//attack(x,y, 2);
						//System.out.println("AI Move 6:" + moves + " AI WINS");
					//}else if((tableAI.getValueAt(0, 2) ==  "X" && tableAI.getValueAt(0, 1) == "X" && tableAI.getValueAt(2, 0) == "O")){
						//attack(x, y, 2);
						//System.out.println("AI Move 6:" + moves + " AI WINS");
					}else if((tableAI.getValueAt(0, 2) ==  "X" && tableAI.getValueAt(0, 1) == "X" && tableAI.getValueAt(2, 1) == "O")){
						tableAI.setValueAt("O", 2, 0);
						moves++;
						System.out.println("AI Move 6:" + moves);
					}else if((tableAI.getValueAt(1, 1) ==  "X" && tableAI.getValueAt(2, 0) == "X" && x != 0 && y != 1)){
						attack(x,y,3);
					}
					
				}
				if(crossPlacement(x,y)){
					if((tableAI.getValueAt(1, 1) == "X" && tableAI.getValueAt(0, 2) == "X" && x != 1 && y != 0)){
						
						attack(x,y,2);
					if((tableAI.getValueAt(0, 2) ==  "X" && tableAI.getValueAt(0, 1) == "X")){
						attack(x, y, 2);
						System.out.println("AI Move 6:" + moves + " AI WINS");
					}else if((tableAI.getValueAt(2, 1) ==  "X" && tableAI.getValueAt(0, 2) == "X")){
						attack(x,y,2);
						System.out.println("AI Move 6:" + moves + " AI WINS");
					}else if((tableAI.getValueAt(1, 2) ==  "X" && tableAI.getValueAt(0, 2) == "X")){
						attack(x,y,2);
						System.out.println("AI Move 6:" + moves + " AI WINS");
					}}else if((tableAI.getValueAt(1, 0) ==  "X" && tableAI.getValueAt(1, 1) == "X")){
						tableAI.setValueAt("O", 1, 2);
						moves++;
						
					}else if((tableAI.getValueAt(1, 1) ==  "X" && tableAI.getValueAt(2, 0) == "X" && x != 0 && y != 1)){
						attack(x,y,3);
					}
				}*/
		    }
		}
	}
	
	private void attack(int x, int y, int attackMove){
		if(attackMove == 1){
			tableAI.setValueAt("O", 0, 2);
			moves++;
		}
		if(attackMove == 2){
			moves++;
			tableAI.setValueAt("O", 1, 0);
			checkWin(1);
		}
		if(attackMove == 3){
			moves++;
			tableAI.setValueAt("O", 0, 1);
			checkWin(1);
		}
		if(attackMove == 4){
			moves++;
			tableAI.setValueAt("O", 2, 0);
			checkWin(1);
		}
		if(attackMove == 5){
			moves++;
			tableAI.setValueAt("O", 0, 2);
		}
		if(attackMove == 6){
			moves++;
			tableAI.setValueAt("O", 0, 2);
		}
	}
	public void userTurn(){
	tableAI.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (e.getClickCount() == 1) {
		    	JTable target = (JTable)e.getSource();
				int row = target.getSelectedRow();
			    int column = target.getSelectedColumn();
			    // do some action if appropriate column
				      
			    target.setValueAt("X", row, column);
			    moves++;
			    System.out.println("UserTurn:" + moves);
			    defend(row, column);
			    
		    }
		}
		});
	}
	
	private boolean cornerPlacement(int x, int y){
		if(((x == 0) && (y == 0)) || ((x == 2) && (y == 2)) || ((x == 0) && (y == 2)) || ((x == 2) && (y == 0))){
			return true;
		}else
			return false;
		
	}
	
	private boolean crossPlacement(int x, int y){
		if(((x == 0) && (y == 1)) || ((x == 1) && (y == 0)) || ((x == 1) && (y == 2)) || ((x == 2) && (y == 1))){
			return true;
		}else
			return false;
	}
	
	private void checkWin(int winner){
		if(winner == 1){
			
		}
	}
	
	public void resetGUI(){
		moves = 0;
		System.out.println(moves);
		int j;
		int i;
			for(j = 0; j < 3; j++){
				for(i = 0; i < 3; i++){
				  
					
					int row = j;
			        int column = i;
			      // do some action if appropriate column
			      
			      tableAI.setValueAt("", row, column);
			      
			      
				}
				if((i == 2) && (j == 2)){
					break;
				}
				
			}
	
	
	}
}

	