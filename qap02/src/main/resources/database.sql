CREATE TABLE tournament (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    loc VARCHAR(500) NOT NULL,
    start_Date VARCHAR(100) NOT NULL,
    end_Date VARCHAR (100) NOT NULL,
    entry_Fee INT(5) NOT NULL,
    prize_Amt INT(7) NOT NULL
);

select * from tournament;

INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (1, "Bally Hally Invitational", "01/01/23", "01/03/23", 1000, 20000);
INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (2, "Glendenning Open", "02/02/23", "02/05/23", 1500, 25000);
INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (3, "Bally Hally Club Championship", "03/05/23", "03/08/23", 500, 10000);
INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (4, "Admirals Skins", "01/01/23", "01/03/23", 500, 5000);
INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (5, "The Wilds Championship", "01/01/23", "01/03/23", 10000, 200000);
INSERT INTO qap02.tournament(id, loc, start_Date, end_Date, entry_Fee, prize_Amt) values (6, "The Wilds Fun Game", "04/19/23", "01/03/23", 10000, 200000);

ALTER TABLE tournament DROP COLUMN prizeAmt;
ALTER TABLE tournament DROP COLUMN entryFee;
ALTER TABLE tournament DROP COLUMN endDate;
ALTER TABLE tournament DROP COLUMN startDate;
ALTER TABLE tournament DROP COLUMN loc;
ALTER TABLE tournament DROP COLUMN id;
DROP TABLE qap02.tournament;
