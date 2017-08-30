package com.techelevator;

public class AfternoonExercises {

	public static void main(String[] args) {
        
        /* 
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch? 
        */
int  bird0 = 4;
bird0 = bird0 -1;
System.out.println(bird0);
        /* 
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests? 
        */
int birdOne = 6;
int nest0 = 3;
int howManyMore = birdOne - nest0;
System.out.println(howManyMore);
        /* 
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods? 
        */
int raccoonsPlaying = 3 - 2;
System.out.println(raccoonsPlaying);
        /* 
        4. There are 5 flowers and 3 bees. How many less bees than flowers? 
        */
int flowers = 5;
int bees = 3;
int HowManyLess = flowers - bees;
System.out.println(HowManyLess);
        /* 
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now? 
        */
int lonelyPigeon = 1;
lonelyPigeon = lonelyPigeon + 1;
System.out.println(lonelyPigeon);
        /* 
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now? 
        */
int Owls = 3;
int newOwls = 2;
int onFence = Owls + newOwls;
System.out.println(onFence);
        /* 
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home? 
        */
int beaversWorking = 2;
int swimmingBeaver = 1;
int beaversStillWorking = beaversWorking - swimmingBeaver;
System.out.println(beaversStillWorking);
        /* 
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all? 
        */
int toucans = 2;
int newToucan = 1;
int toucansInAll = toucans + newToucan;
System.out.println(toucansInAll);
        /* 
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts? 
        */
int squirrels = 4;
int nuts = 2;
System.out.println(squirrels - nuts);
        /* 
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find? 
        */
int quarter = 25;
int dime = 10;
int nickel = 5;
nickel = nickel * 2;
double moneyFound = (quarter + dime + nickel) / 100.00;
System.out.println(moneyFound);

        /* 
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all? 
        */
int hilt = 18;
int macadams = 17;
int flan = 17;
System.out.println(hilt + macadams + flan);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
int yoyo = 24;
int whistle = 14;
double spentInAll = (yoyo + whistle) / 100.00;
// String dollarSign = "$"; //Why whouldn't this work???
System.out.println("$" + spentInAll);

int yoyoQ = 24;
int whistleQ = 14;
double spentInAllQ = (yoyoQ + whistleQ) / 100.00;
String dollarSign = "$"; 
System.out.println(dollarSign + spentInAllQ);

/*≈j
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
int marshmallows = 8 + 10;
System.out.println(marshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
int hiltHouse = 29;
int brecknock = 17;
System.out.println("Mrs. Hilt's house had " + (hiltHouse - brecknock) + " more inches of snow.");
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
int hiltsMoney = 10;
int costTruck = 3;
int costPencilCase = 2;
int moneyLeftHilt = hiltsMoney - costTruck - costPencilCase;
System.out.println("$" + moneyLeftHilt);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
int marblesJosh = 16;
int marblesLost = 7;
int marblesLeft = marblesJosh - marblesLost;
System.out.println("He has " + marblesLeft + " marbles left.");
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int meganSeashells = 19;
        int meganWants = 25;
        System.out.println("She needs " + (meganWants - meganSeashells)  + " seashells to have 25 in her collection.");
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
           int bradBalloons = 17;
           int redBalloons = 8;
           int totalBalloons = bradBalloons - redBalloons;
           System.out.println("He has " + totalBalloons + " green balloons.");
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
        int booksOnShelf = 38;
        int newBooksOnShelf = 10;
        int booksNowShelf = booksOnShelf + newBooksOnShelf;
        System.out.println(booksNowShelf);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
        int beeLegs = 6;
        int legsPerBee = 8;
        int eightBeesLegs = beeLegs * legsPerBee;
        System.out.println(eightBeesLegs);
        
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
        int iceCreamConeCost = 99;
        int numberOfCones = 2;
        double costOfCones = (iceCreamConeCost * numberOfCones) / 100.00;
        System.out.println("Two cones cost " + dollarSign + costOfCones + ".");
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int rocksNeeded = 125;
        int rocksNow = 64;
        System.out.println(rocksNeeded - rocksNow);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
        System.out.println("She has " + (38 - 15) + " marbles left.");
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        System.out.println("They have " + (78 - 32) + " miles left.");
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        int hour = 60;
        int shovSaturdayMorning = hour + 30;
        int shovSaturdayAfternoon = 45;
        int totalTimeShov = shovSaturdayMorning + shovSaturdayAfternoon;
        		System.out.println("She spent " + totalTimeShov + " minutes. ");
        /*    
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
      int  hotDogsBought = 6;
      int hotDogCost = 50;
      double hotDogTotal = ( hotDogsBought + hotDogCost ) / 100.00 ;
        		System.out.println(dollarSign + hotDogTotal);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
        int hiltsPencilMoney = 50;
        int pencilCost = 7;
        int totalPencilsBought = hiltsPencilMoney / pencilCost;
        		System.out.println(totalPencilsBought);
        /*    
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        		
        	int hiltSaw = 33 - 20;	
        		System.out.println(hiltSaw);
        /*    
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
        int katesChange = 100 - 54;
        System.out.println(katesChange);
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
        int marksTrees = 13 + 12;
        System.out.println(marksTrees);
        /*    
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
        int day = 24;
        int timeToGranny = day * 2;
        System.out.println(timeToGranny);
        
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        
        int gumNeeded = 4 * 5;
        System.out.println(gumNeeded);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        int moneyLeft = 3 - 1;
        System.out.println(moneyLeft);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
        int peopleOnBoats = 5 * 3;
        System.out.println(peopleOnBoats);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int legosEllen = 380 - 57;
        System.out.println(legosEllen);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
        int muffinMan = 83 -35;
        System.out.println(muffinMan);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
        int willyWins = 1400 - 290;
        System.out.println(willyWins);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
        int stickerMania = 22 * 10;
        System.out.println(stickerMania);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
        int cupcakePerPerson = 96 / 8;
        System.out.println(cupcakePerPerson);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
        int cookieJars = 47 % 6;
        System.out.println(cookieJars);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
        int frenchBagelsNotGiven = 59 % 8;
        System.out.println(frenchBagelsNotGiven);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
         int traysNeeded = 276 / 12;
         System.out.println(traysNeeded);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
        int pretzelServings = 480 / 12;
        System.out.println(pretzelServings);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
        int cupcakeGiveaway = (53 - 2) / 3   ;
        System.out.println(cupcakeGiveaway);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
        int uneatenCarrotSticks = 74 % 12;
        System.out.println(uneatenCarrotSticks);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
        int bearsOnShelves = 98 / 7;
        System.out.println(bearsOnShelves);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
        int albumsNeeded = 480 / 20;
        System.out.println(albumsNeeded);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
        int tradingCards = 94;
        		int fullBox = 8;
        		int boxesFilled = tradingCards / fullBox;
        		int unfilledBox = tradingCards % fullBox;
        				 System.out.println("He filled " + boxesFilled + " and the unfilled box had " + unfilledBox + " left in it.");
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
int booksPerShelf = 210 / 10;
System.out.println(booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
         int frenchBagelsServed = 17 / 7;
         System.out.println(frenchBagelsServed);
        
	}

}
