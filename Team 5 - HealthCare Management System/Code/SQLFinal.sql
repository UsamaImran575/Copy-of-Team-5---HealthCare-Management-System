create database finalproj
use finalproj

create table users
(
username nvarchar(30),
userid nvarchar(30) primary key,
pass nvarchar(30),
urole int,
ID int IDENTITY(1, 1) unique, 
);
insert into users values('a','a','a',0)

select * from users
create table Specialist
(
doctorID int FOREIGN KEY REFERENCES users(ID) on delete cascade on update cascade ,
Specializtion_in nvarchar(30)
);

select * from chatbox
create table Chatbox
(
messageBy nvarchar(30) foreign key references users(userid) on delete cascade on update cascade,
messagetxt nvarchar(200)
);
select * from Specialist

drop table Rating
create table Rating
(
 doctorID int FOREIGN KEY REFERENCES users(ID) on delete cascade on update cascade ,
 rating float,
 docdescription nvarchar(500)
);

create table Disease
(
ID int IDENTITY(1, 1) unique, 
name nvarchar(30) primary key,
)

create table patientDiseases
(
patientid int foreign Key References users(ID) on delete cascade on update cascade,
diseaseid int foreign Key References Disease(ID),
diagnosedate nvarchar(30),
)

create table symptoms
(
ID int IDENTITY(1, 1) unique, 
name nvarchar(30) primary key,
)

create table symptomsOfDisease
(
  diseaseID int Foreign Key References Disease(ID) on delete cascade on update cascade,
  symptomID int Foreign Key References symptoms(ID) on delete cascade on update cascade,
  unique (diseaseID,symptomID)
);

create table constraintOfDisease
(
 foodName nvarchar(30),
 diseaseID int Foreign Key References Disease(ID) on delete cascade on update cascade,
 unique (foodName,diseaseID)
);

drop table Medicine
delete from Medicine
create table Medicine
(

ID int IDENTITY(1, 1) unique, 
name nvarchar(30) primary key,
price int,

)
create table treatableDiseaseByMedicine
(
 medID Int foreign Key RefErences Medicine(ID)on delete cascade on update cascade,
 diseaseID Int foreign Key RefErences Disease(ID) on delete cascade on update cascade,
 dosage float,
 times int,
 duration int,
 minage int,
 maxage int,

);

DBCC CHECKIDENT ("dbo.symptoms", RESEED, 0);

select * from symptoms

delete from symptoms
insert into symptoms values('Cough')                   --1
insert into symptoms values('Diarrhea')
insert into symptoms values('Dizziness')
insert into symptoms values('Fatigue')
insert into symptoms values('Fever')                   --5
insert into symptoms values('Headache')
insert into symptoms values('Muscle cramp')
insert into symptoms values('Nausea')                       --unease chest, vomit
insert into symptoms values('Thraoat irritation')
insert into symptoms values('Shortness of breath')    --10
insert into symptoms values('Back pain')
insert into symptoms values('Jaw pain')
insert into symptoms values('Neck pain')
insert into symptoms values('Throat pain')
insert into symptoms values('Numbness')                --15
insert into symptoms values('Weakness')
insert into symptoms values('Chest pain')
insert into symptoms values('Chest pressure')
insert into symptoms values('Chest discomfort')
insert into symptoms values('Blood in stool')          --20
insert into symptoms values('Mouth sore')
insert into symptoms values('Weight loss')
insert into symptoms values('Abdominal pain')
insert into symptoms values('Decrease ability to exercise')   
insert into symptoms values('Cough that dont go away')   --25
insert into symptoms values('Trouble breathing')
insert into symptoms values('Rapid pulse')
insert into symptoms values('Vomiting')
insert into symptoms values('Blood in urine')
insert into symptoms values('Itchy skin')               --30
insert into symptoms values('Insomnia')
insert into symptoms values('Swelling of legs')
insert into symptoms values('Tiredness')
insert into symptoms values('Dry cough')
insert into symptoms values('Increased Hunger')          --35
insert into symptoms values('Frequent urination')
insert into symptoms values('Vision  Problem')
insert into symptoms values('Irregular Heart beat')
insert into symptoms values('Oily stools')
insert into symptoms values('Coughing up blood')         --40
insert into symptoms values('Coughing up mucus')
insert into symptoms values('Pain while breathing')
insert into symptoms values('Abnormal breathing sound')
insert into symptoms values('Strokes')
insert into symptoms values('Forget names')             --45
insert into symptoms values('Memory lapses')
insert into symptoms values('Repeated irregular behavior')
insert into symptoms values('Increased thirst')
insert into symptoms values('Craving for salty foods')
insert into symptoms values('Lips swelling')             --50
insert into symptoms values('Tongue swelling')
insert into symptoms values('Trouble sleeping')
insert into symptoms values('Loss of appetite')
insert into symptoms values('Hair loss')
insert into symptoms values('Rapid Weight loss')         --55
insert into symptoms values('Excessive sweating')
insert into symptoms values('Bone and joint pain')
insert into symptoms values('Blocked or runny nose')
insert into symptoms values('Itchiness')
insert into symptoms values('Sore or dry skin')          --60
insert into symptoms values('Yellow crust on skin')
insert into symptoms values('Mania')
insert into symptoms values('Depression')
insert into symptoms values('Hallucinations')
insert into symptoms values('Swelling')      --65
insert into symptoms values('Blood from bottom')
insert into symptoms values('Gas and bloating')
insert into symptoms values('Swelling around big toe')
insert into symptoms values('bump in foot shape ')
insert into symptoms values('Temporary hearing loss')        --70
insert into symptoms values('Cluster spots') 
insert into symptoms values('Blistering red rash') 
insert into symptoms values('Bluish skin') 
insert into symptoms values('Pee more often and urgently') 
insert into symptoms values('Dry mouth or lips ')      --75
insert into symptoms values('Foot or leg turning inward') 
insert into symptoms values('Fear, anxiety or deja vu') 
insert into symptoms values('Jaundice') 
insert into symptoms values('Dark urine') 

select* from symptoms

INSERT INTO Disease VALUES('Heart Disease')    --1
INSERT INTO Disease VALUES('Crohons Disease')
INSERT INTO Disease VALUES('Pancreatisis')
INSERT INTO Disease VALUES('Lungs Disease')
INSERT INTO Disease VALUES('Alzheimers disease')      --5
INSERT INTO Disease VALUES('Addisons disease')
INSERT INTO Disease VALUES('Anaphylaxis disease')
INSERT INTO Disease VALUES('Asthma')
INSERT INTO Disease VALUES('Appendicitis')
INSERT INTO Disease VALUES('Anorexia nervosa')            --10
INSERT INTO Disease VALUES('Acute myeloid leukaemia')
INSERT INTO Disease VALUES('Allergic rhinitis')
INSERT INTO Disease VALUES('Atopic eczema')
INSERT INTO Disease VALUES('Bipolar disorder')
INSERT INTO Disease VALUES('Schizophrenia')            --15
INSERT INTO Disease VALUES('Sepsis')
INSERT INTO Disease VALUES('Bone cancer')
INSERT INTO Disease VALUES('Bowel cancer')
INSERT INTO Disease VALUES('Bowel incontinence')
INSERT INTO Disease VALUES('Brain tumours')           --20
INSERT INTO Disease VALUES('Bronchiectasis')
INSERT INTO Disease VALUES('Bronchitis')
INSERT INTO Disease VALUES('Bulimia')
INSERT INTO Disease VALUES('Bunion')
INSERT INTO Disease VALUES('Catarrh')            --25
INSERT INTO Disease VALUES('Cellulitis')
INSERT INTO Disease VALUES('Chest infection')
INSERT INTO Disease VALUES('Chest pain')
INSERT INTO Disease VALUES('Chickenpox')
INSERT INTO Disease VALUES('Chilblains')            --30
INSERT INTO Disease VALUES('Chronic fatigue syndrome')
INSERT INTO Disease VALUES('Chronic kidney disease')
INSERT INTO Disease VALUES('Chronic lymphocytic leukaemia')
INSERT INTO Disease VALUES('Coeliac disease')
INSERT INTO Disease VALUES('Common cold')            --35
INSERT INTO Disease VALUES('Cystitis')
INSERT INTO Disease VALUES('Dehydration')
INSERT INTO Disease VALUES('Diabetes')
INSERT INTO Disease VALUES('Discoid eczema')
INSERT INTO Disease VALUES('Dystonia')           --40
INSERT INTO Disease VALUES('Ebola virus')
INSERT INTO Disease VALUES('Epilepsy')
INSERT INTO Disease VALUES('Ewing sarcoma')
INSERT INTO Disease VALUES('Flu')
INSERT INTO Disease VALUES('Food poisoning')           --45
INSERT INTO Disease VALUES('Gallstones')
INSERT INTO Disease VALUES('Hepatitis A')
INSERT INTO Disease VALUES('Hepatitis B')
INSERT INTO Disease VALUES('Hepatitis C')
INSERT INTO Disease VALUES('Liver cancer')      

--50

delete from symptomsOfDisease
select * from symptomsOfDisease
insert into symptomsOfDisease values(1,5)
insert into symptomsOfDisease values(1,4)
insert into symptomsOfDisease values(1,6)
insert into symptomsOfDisease values(1,12)
insert into symptomsOfDisease values(1,13)
insert into symptomsOfDisease values(1,14)
insert into symptomsOfDisease values(1,15)
insert into symptomsOfDisease values(1,17)
insert into symptomsOfDisease values(1,18)
insert into symptomsOfDisease values(1,19)
insert into symptomsOfDisease values(1,20)
insert into symptomsOfDisease values(1,28)
insert into symptomsOfDisease values(1,39)

--adding crohons disease symptoms
insert into symptomsOfDisease values(2,5)
insert into symptomsOfDisease values(2,6)
insert into symptomsOfDisease values(2,17)
insert into symptomsOfDisease values(2,4)
insert into symptomsOfDisease values(2,21)
insert into symptomsOfDisease values(2,23)
insert into symptomsOfDisease values(2,24)
insert into symptomsOfDisease values(2,40)
insert into symptomsOfDisease values(2,39)

--adding pancreatic disease symptoms
insert into symptomsOfDisease values(3,4)
insert into symptomsOfDisease values(3,5)
insert into symptomsOfDisease values(3,6)
insert into symptomsOfDisease values(3,40)
insert into symptomsOfDisease values(3,28)
insert into symptomsOfDisease values(3,29)
insert into symptomsOfDisease values(3,9)
insert into symptomsOfDisease values(3,23)
insert into symptomsOfDisease values(3,24)

---adding lungs disease symptoms
insert into symptomsOfDisease values(4,4)
insert into symptomsOfDisease values(4,5)
insert into symptomsOfDisease values(4,6)
insert into symptomsOfDisease values(4,11)
insert into symptomsOfDisease values(4,27)
insert into symptomsOfDisease values(4,26)
insert into symptomsOfDisease values(4,42)
insert into symptomsOfDisease values(4,43)
insert into symptomsOfDisease values(4,41)
insert into symptomsOfDisease values(4,18)

insert into symptomsOfDisease values(5,44)
insert into symptomsOfDisease values(5,45)
insert into symptomsOfDisease values(5,46)
insert into symptomsOfDisease values(5,47)

insert into symptomsOfDisease values(6,4)
insert into symptomsOfDisease values(6,36)
insert into symptomsOfDisease values(6,48)
insert into symptomsOfDisease values(6,49)

insert into symptomsOfDisease values(7,3)
insert into symptomsOfDisease values(7,26)
insert into symptomsOfDisease values(7,30)
insert into symptomsOfDisease values(7,50)
insert into symptomsOfDisease values(7,51)

insert into symptomsOfDisease values(8,17)
insert into symptomsOfDisease values(8,26)
insert into symptomsOfDisease values(8,43)
insert into symptomsOfDisease values(8,52)

insert into symptomsOfDisease values(9,2)
insert into symptomsOfDisease values(9,5)
insert into symptomsOfDisease values(9,8)
insert into symptomsOfDisease values(9,53)

insert into symptomsOfDisease values(10,3)
insert into symptomsOfDisease values(10,28)
insert into symptomsOfDisease values(10,53)
insert into symptomsOfDisease values(10,54)

insert into symptomsOfDisease values(11,26)
insert into symptomsOfDisease values(11,42)
insert into symptomsOfDisease values(11,5)
insert into symptomsOfDisease values(11,4)
insert into symptomsOfDisease values(11,57)

insert into symptomsOfDisease values(12,3)
insert into symptomsOfDisease values(12,4)
insert into symptomsOfDisease values(12,58)
insert into symptomsOfDisease values(12,59)

insert into symptomsOfDisease values(13,4)
insert into symptomsOfDisease values(13,5)
insert into symptomsOfDisease values(13,59)
insert into symptomsOfDisease values(13,60)
insert into symptomsOfDisease values(13,61)

insert into symptomsOfDisease values(14,6)
insert into symptomsOfDisease values(14,33)
insert into symptomsOfDisease values(14,62)
insert into symptomsOfDisease values(14,63)
insert into symptomsOfDisease values(14,52)
insert into symptomsOfDisease values(14,53)

insert into symptomsOfDisease values(15,6)
insert into symptomsOfDisease values(15,33)
insert into symptomsOfDisease values(15,62)
insert into symptomsOfDisease values(15,63)
insert into symptomsOfDisease values(15,64)
insert into symptomsOfDisease values(15,53)

insert into symptomsOfDisease values(16,7)
insert into symptomsOfDisease values(16,2)
insert into symptomsOfDisease values(16,3)
insert into symptomsOfDisease values(16,5)
insert into symptomsOfDisease values(16,38)
insert into symptomsOfDisease values(16,43)

insert into symptomsOfDisease values(17,5)
insert into symptomsOfDisease values(17,55)
insert into symptomsOfDisease values(17,57)
insert into symptomsOfDisease values(17,65)
insert into symptomsOfDisease values(17,4)

insert into symptomsOfDisease values(18,2)
insert into symptomsOfDisease values(18,4)
insert into symptomsOfDisease values(18,20)
insert into symptomsOfDisease values(18,5)
insert into symptomsOfDisease values(18,22)
insert into symptomsOfDisease values(18,66)

insert into symptomsOfDisease values(19,2)
insert into symptomsOfDisease values(19,4)
insert into symptomsOfDisease values(19,67)

insert into symptomsOfDisease values(20,6)
insert into symptomsOfDisease values(20,8)
insert into symptomsOfDisease values(20,28)
insert into symptomsOfDisease values(20,3)
insert into symptomsOfDisease values(20,46)
insert into symptomsOfDisease values(20,44)

insert into symptomsOfDisease values(21,10)
insert into symptomsOfDisease values(21,17)
insert into symptomsOfDisease values(21,33)
insert into symptomsOfDisease values(21,57)
insert into symptomsOfDisease values(21,40)

insert into symptomsOfDisease values(22,9)
insert into symptomsOfDisease values(22,6)
insert into symptomsOfDisease values(22,33)
insert into symptomsOfDisease values(22,58)

insert into symptomsOfDisease values(23,31)
insert into symptomsOfDisease values(23,33)
insert into symptomsOfDisease values(23,63)
insert into symptomsOfDisease values(23,55)

insert into symptomsOfDisease values(24,4)
insert into symptomsOfDisease values(24,68)
insert into symptomsOfDisease values(24,69)

insert into symptomsOfDisease values(25,70)
insert into symptomsOfDisease values(25,25)
insert into symptomsOfDisease values(25,14)
insert into symptomsOfDisease values(25,17)
insert into symptomsOfDisease values(25,6)
insert into symptomsOfDisease values(25,58)

insert into symptomsOfDisease values(26,4)
insert into symptomsOfDisease values(26,30)
insert into symptomsOfDisease values(26,60)

insert into symptomsOfDisease values(27,4)
insert into symptomsOfDisease values(27,5)
insert into symptomsOfDisease values(27,17)
insert into symptomsOfDisease values(27,10)
insert into symptomsOfDisease values(27,26)
insert into symptomsOfDisease values(27,27)
insert into symptomsOfDisease values(27,38)

insert into symptomsOfDisease values(28,4)
insert into symptomsOfDisease values(28,10)
insert into symptomsOfDisease values(28,11)
insert into symptomsOfDisease values(28,12)
insert into symptomsOfDisease values(28,17)
insert into symptomsOfDisease values(28,18)
insert into symptomsOfDisease values(28,19)
insert into symptomsOfDisease values(28,40)

insert into symptomsOfDisease values(29,71)
insert into symptomsOfDisease values(29,4)
insert into symptomsOfDisease values(29,72)
insert into symptomsOfDisease values(29,5)
insert into symptomsOfDisease values(29,6)
insert into symptomsOfDisease values(29,21)

insert into symptomsOfDisease values(30,72)
insert into symptomsOfDisease values(30,4)
insert into symptomsOfDisease values(30,68)
insert into symptomsOfDisease values(30,30)
insert into symptomsOfDisease values(30,73)

insert into symptomsOfDisease values(31,3)
insert into symptomsOfDisease values(31,4)
insert into symptomsOfDisease values(31,5)
insert into symptomsOfDisease values(31,8)
insert into symptomsOfDisease values(31,52)
insert into symptomsOfDisease values(31,53)

insert into symptomsOfDisease values(32,8)
insert into symptomsOfDisease values(32,10)
insert into symptomsOfDisease values(32,26)
insert into symptomsOfDisease values(32,31)
insert into symptomsOfDisease values(32,30)
insert into symptomsOfDisease values(32,29)

insert into symptomsOfDisease values(33,4)
insert into symptomsOfDisease values(33,5)
insert into symptomsOfDisease values(33,26)
insert into symptomsOfDisease values(33,55)
insert into symptomsOfDisease values(33,33)
insert into symptomsOfDisease values(33,61)

insert into symptomsOfDisease values(34,33)
insert into symptomsOfDisease values(34,2)
insert into symptomsOfDisease values(34,55)
insert into symptomsOfDisease values(34,60)
insert into symptomsOfDisease values(34,63)
insert into symptomsOfDisease values(34,8)

insert into symptomsOfDisease values(35,3)
insert into symptomsOfDisease values(35,4)
insert into symptomsOfDisease values(35,5)
insert into symptomsOfDisease values(35,6)
insert into symptomsOfDisease values(35,26)
insert into symptomsOfDisease values(35,25)
insert into symptomsOfDisease values(35,58)

insert into symptomsOfDisease values(36,4)
insert into symptomsOfDisease values(36,33)
insert into symptomsOfDisease values(36,29)
insert into symptomsOfDisease values(36,74)

insert into symptomsOfDisease values(37,3)
insert into symptomsOfDisease values(37,6)
insert into symptomsOfDisease values(37,33)
insert into symptomsOfDisease values(37,75)

insert into symptomsOfDisease values(38,4)
insert into symptomsOfDisease values(38,36)
insert into symptomsOfDisease values(38,48)
insert into symptomsOfDisease values(38,30)
insert into symptomsOfDisease values(38,55)

insert into symptomsOfDisease values(39,33)
insert into symptomsOfDisease values(39,30)
insert into symptomsOfDisease values(39,60)
insert into symptomsOfDisease values(39,71)
insert into symptomsOfDisease values(39,72)

insert into symptomsOfDisease values(40,7)
insert into symptomsOfDisease values(40,57)
insert into symptomsOfDisease values(40,76)

insert into symptomsOfDisease values(41,5)
insert into symptomsOfDisease values(41,6)
insert into symptomsOfDisease values(41,57)
insert into symptomsOfDisease values(41,9)

insert into symptomsOfDisease values(42,33)
insert into symptomsOfDisease values(42,3)
insert into symptomsOfDisease values(42,77)

insert into symptomsOfDisease values(43,33)
insert into symptomsOfDisease values(43,5)
insert into symptomsOfDisease values(43,55)
insert into symptomsOfDisease values(43,65)

insert into symptomsOfDisease values(44,33)
insert into symptomsOfDisease values(44,4)
insert into symptomsOfDisease values(44,5)
insert into symptomsOfDisease values(44,6)
insert into symptomsOfDisease values(44,52)
insert into symptomsOfDisease values(44,53)
insert into symptomsOfDisease values(44,9)
insert into symptomsOfDisease values(44,58)

insert into symptomsOfDisease values(45,28)
insert into symptomsOfDisease values(45,8)
insert into symptomsOfDisease values(45,2)
insert into symptomsOfDisease values(45,5)
insert into symptomsOfDisease values(45,53)
insert into symptomsOfDisease values(45,55)

insert into symptomsOfDisease values(46,23)
insert into symptomsOfDisease values(46,5)

insert into symptomsOfDisease values(47,33)
insert into symptomsOfDisease values(47,57)
insert into symptomsOfDisease values(47,5)
insert into symptomsOfDisease values(47,53)
insert into symptomsOfDisease values(47,23)
insert into symptomsOfDisease values(47,30)
insert into symptomsOfDisease values(47,78)

insert into symptomsOfDisease values(48,33)
insert into symptomsOfDisease values(48,5)
insert into symptomsOfDisease values(48,53)
insert into symptomsOfDisease values(48,23)
insert into symptomsOfDisease values(48,79)
insert into symptomsOfDisease values(48,78)
insert into symptomsOfDisease values(48,2)

insert into symptomsOfDisease values(49,5)
insert into symptomsOfDisease values(49,33)
insert into symptomsOfDisease values(49,53)
insert into symptomsOfDisease values(49,23)
insert into symptomsOfDisease values(49,78)

insert into symptomsOfDisease values(50,53)
insert into symptomsOfDisease values(50,55)
insert into symptomsOfDisease values(50,28)
insert into symptomsOfDisease values(50,23)
insert into symptomsOfDisease values(50,33)
insert into symptomsOfDisease values(50,78)

select * from symptomsOfDisease

 --Constraints--
Insert into constraintOfDisease Values('Fast Food Burgers',1)
Insert into constraintOfDisease Values('Deep Fried Food',1)
Insert into constraintOfDisease Values('Candy',1)
Insert into constraintOfDisease Values('SoftDrinks',1)
Insert into constraintOfDisease Values('Microwave Popcorn',1)

--adding constraint of crohons disease
Insert into constraintOfDisease Values('Alcohol',2)
Insert into constraintOfDisease Values('Butter',2)
Insert into constraintOfDisease Values('Myonise',2)
Insert into constraintOfDisease Values('Carbonated Drinks',2)
Insert into constraintOfDisease Values('Fried Eggs',2)

--adding constraint of pancreatsis
Insert into constraintOfDisease Values('Red meat.',3)
Insert into constraintOfDisease Values('Organ meats.',3)
Insert into constraintOfDisease Values('Fried foods.',3)
Insert into constraintOfDisease Values('Full-fat dairy.',3)
Insert into constraintOfDisease Values('Pastries and desserts',3)

--adding constraint of Lungs Disease
Insert into constraintOfDisease Values('Excessive Salt',4)
Insert into constraintOfDisease Values('Deep Fried Food',4)
Insert into constraintOfDisease Values('Dairy Products',4)
Insert into constraintOfDisease Values('SoftDrinks',4)
Insert into constraintOfDisease Values('Acidic Food',4)

--adding constraint of Alzheimers
Insert into constraintOfDisease Values('White breads',5)
Insert into constraintOfDisease Values('pasta',5)
Insert into constraintOfDisease Values('processed meat',5)
Insert into constraintOfDisease Values('cheese',5)

Insert into constraintOfDisease Values('white sugar',6)
Insert into constraintOfDisease Values('white flour',6)
Insert into constraintOfDisease Values('caffeine',6)
Insert into constraintOfDisease Values('soda',6)
Insert into constraintOfDisease Values('fried food',6)

Insert into constraintOfDisease Values('nuts',7)
Insert into constraintOfDisease Values('almonds',7)
Insert into constraintOfDisease Values('fish and shellfish',7)
Insert into constraintOfDisease Values('hazelnuts',7)
Insert into constraintOfDisease Values('eggs',7)

Insert into constraintOfDisease Values('Cows milk',8)
Insert into constraintOfDisease Values('Peanuts',8)
Insert into constraintOfDisease Values('Shrimp and shellfish',8)
Insert into constraintOfDisease Values('Soy',8)
Insert into constraintOfDisease Values('Tree nuts',8)

Insert into constraintOfDisease Values('cocao',9)
Insert into constraintOfDisease Values('orange and melon',9)
Insert into constraintOfDisease Values('cumin and nut',9)
Insert into constraintOfDisease Values('barley',9)
Insert into constraintOfDisease Values('beans',9)

Insert into constraintOfDisease Values('oilly cooked food',10)
Insert into constraintOfDisease Values('lactose foods',10)
Insert into constraintOfDisease Values('high-sugar diet.',10)

Insert into constraintOfDisease Values('high fat dairy',11)
Insert into constraintOfDisease Values('low protein foods',11)
Insert into constraintOfDisease Values('fast food.',11)
Insert into constraintOfDisease Values('uncooked vegetables',11)
Insert into constraintOfDisease Values('salad bars',11)

Insert into constraintOfDisease Values('fast food',12)
Insert into constraintOfDisease Values('uncooked vegetables',12)
Insert into constraintOfDisease Values('salad bars',12)
Insert into constraintOfDisease Values('Alcohol',12)
Insert into constraintOfDisease Values('Coffee',12)

Insert into constraintOfDisease Values('alcohol',13)
Insert into constraintOfDisease Values('gluten',13)
Insert into constraintOfDisease Values('peanuts',13)
Insert into constraintOfDisease Values('dairy',13)
Insert into constraintOfDisease Values('seafood',13)

Insert into constraintOfDisease Values('Caffeine',14)
Insert into constraintOfDisease Values('Alcohol',14)
Insert into constraintOfDisease Values('Sugar',14)
Insert into constraintOfDisease Values('fat',14)

Insert into constraintOfDisease Values('Caffeine',15)
Insert into constraintOfDisease Values('gluten',15)
Insert into constraintOfDisease Values('Sugar',15)
Insert into constraintOfDisease Values('bread',15)

Insert into constraintOfDisease Values('Caffeine',16)
Insert into constraintOfDisease Values('Alcohol',16)
Insert into constraintOfDisease Values('Sugar',16)
Insert into constraintOfDisease Values('white bread',16)
Insert into constraintOfDisease Values('Oilly food',16)

Insert into constraintOfDisease Values('bacon',17)
Insert into constraintOfDisease Values('ham',17)
Insert into constraintOfDisease Values('sausages',17)
Insert into constraintOfDisease Values('barbequed or baked meats',17)
Insert into constraintOfDisease Values('Excessive salt',17)

Insert into constraintOfDisease Values('processed meat',18)
Insert into constraintOfDisease Values('red meat',18)
Insert into constraintOfDisease Values('high fibre fruits',18)
Insert into constraintOfDisease Values('brussel sprouts',18)
Insert into constraintOfDisease Values('fizzy drinks',18)
Insert into constraintOfDisease Values('cabbage',18)

Insert into constraintOfDisease Values('chocolate',19)
Insert into constraintOfDisease Values('dairy products',19)
Insert into constraintOfDisease Values('alcohol',19)
Insert into constraintOfDisease Values('caffeine',19)

Insert into constraintOfDisease Values('processed meat',20)
Insert into constraintOfDisease Values('red meat',20)
Insert into constraintOfDisease Values('alcohol',20)
Insert into constraintOfDisease Values('caffeine',20)
Insert into constraintOfDisease Values('Excessive salt',20)

Insert into constraintOfDisease Values('starchy foods',21)
Insert into constraintOfDisease Values('cakes',21)
Insert into constraintOfDisease Values('sweets',21)
Insert into constraintOfDisease Values('fizzy drinks',21)

Insert into constraintOfDisease Values('caffeine',22)
Insert into constraintOfDisease Values('alcohol',22)
Insert into constraintOfDisease Values('dairy milk',22)
Insert into constraintOfDisease Values('fizzy drinks',22)

Insert into constraintOfDisease Values('caffeine',23)
Insert into constraintOfDisease Values('Excessive salt',23)
Insert into constraintOfDisease Values('fizzy drinks',23)
Insert into constraintOfDisease Values('fast foods',23)

Insert into constraintOfDisease Values('sugary soft drinks',24)
Insert into constraintOfDisease Values('sugary food',24)
Insert into constraintOfDisease Values('junk food',24)
Insert into constraintOfDisease Values('refined flour',24)

Insert into constraintOfDisease Values('oranges',25)
Insert into constraintOfDisease Values('Dairy products',25)
Insert into constraintOfDisease Values('white flour',25)
Insert into constraintOfDisease Values('refined sugary foods',25)

Insert into constraintOfDisease Values('tea',26)
Insert into constraintOfDisease Values('Alcohol',26)
Insert into constraintOfDisease Values('ice cold deserts',26)

Insert into constraintOfDisease Values('Red meat',27)
Insert into constraintOfDisease Values('Cheese',27)
Insert into constraintOfDisease Values('Yogurt',27)
Insert into constraintOfDisease Values('Ice Cream',27)
Insert into constraintOfDisease Values('Butter',27)

Insert into constraintOfDisease Values('High salt',28)
Insert into constraintOfDisease Values('sugar',28)
Insert into constraintOfDisease Values('saturated fat',28)
Insert into constraintOfDisease Values('fizzy drinks',28)

Insert into constraintOfDisease Values('Salty food',29)
Insert into constraintOfDisease Values('vegetable-blend juices',29)
Insert into constraintOfDisease Values('crunchy and acidic foods',29)
Insert into constraintOfDisease Values('fizzy drinks',29)

Insert into constraintOfDisease Values('cold food',30)
Insert into constraintOfDisease Values('ginger',30)
Insert into constraintOfDisease Values('turmeric',30)
Insert into constraintOfDisease Values('cinnamon',30)

Insert into constraintOfDisease Values('White Rice',31)
Insert into constraintOfDisease Values('processed meat',31)
Insert into constraintOfDisease Values('sugar',31)
Insert into constraintOfDisease Values(' fried foods',31)

Insert into constraintOfDisease Values('Avocados',32)
Insert into constraintOfDisease Values('Canned foods',32)
Insert into constraintOfDisease Values('wheat bread',32)
Insert into constraintOfDisease Values('Brown rice',32)
Insert into constraintOfDisease Values('Dairy',32)
Insert into constraintOfDisease Values('Oranges',32)

Insert into constraintOfDisease Values('uncooked fish',33)
Insert into constraintOfDisease Values('raw or rare meat',33)
Insert into constraintOfDisease Values('uncooked vegetables',33)
Insert into constraintOfDisease Values('undercooked eggs',33)
Insert into constraintOfDisease Values('salad bars',33)

Insert into constraintOfDisease Values('bread',34)
Insert into constraintOfDisease Values('pasta',34)
Insert into constraintOfDisease Values('cereals',34)
Insert into constraintOfDisease Values('biscuits or crackers',34)
Insert into constraintOfDisease Values('cakes and pastries',34)

Insert into constraintOfDisease Values('Sweets',35)
Insert into constraintOfDisease Values('Simple carbs',35)
Insert into constraintOfDisease Values('Alcohol',35)
Insert into constraintOfDisease Values('Spicy foods',35)
Insert into constraintOfDisease Values('Citrus fruits',35)

Insert into constraintOfDisease Values('Coffee and Tea',36)
Insert into constraintOfDisease Values('soda',36)
Insert into constraintOfDisease Values('cranberry juice',36)
Insert into constraintOfDisease Values('Spicy foods',36)
Insert into constraintOfDisease Values('Hot peppers',36)

Insert into constraintOfDisease Values('high-protein drinks',37)
Insert into constraintOfDisease Values('alcoholic beverages',37)
Insert into constraintOfDisease Values('Spicy foods',37)

Insert into constraintOfDisease Values('Sugar-Sweetened Beverages',38)
Insert into constraintOfDisease Values('White Bread',38)
Insert into constraintOfDisease Values('Pasta',38)
Insert into constraintOfDisease Values('Rice',38)
Insert into constraintOfDisease Values('Dried Fruit',38)
Insert into constraintOfDisease Values('Honey, Nectar and Maple Syrup',38)

Insert into constraintOfDisease Values('citrus fruits',39)
Insert into constraintOfDisease Values('dairy',39)
Insert into constraintOfDisease Values('eggs',39)
Insert into constraintOfDisease Values('spices ie vanilla, cloves',39)
Insert into constraintOfDisease Values('tomatoes',39)

Insert into constraintOfDisease Values('high fat',40)
Insert into constraintOfDisease Values('cholesterol',40)
Insert into constraintOfDisease Values('fibreless',40)
Insert into constraintOfDisease Values('Red meat',40)

Insert into constraintOfDisease Values('bat',41)
Insert into constraintOfDisease Values('Bushmeat',41)
Insert into constraintOfDisease Values('uncooked food',41)
Insert into constraintOfDisease Values('raw meat',41)

Insert into constraintOfDisease Values('Milk',42)
Insert into constraintOfDisease Values('butter',42)
Insert into constraintOfDisease Values('hamburgers',42)
Insert into constraintOfDisease Values('heavy cream',42)

Insert into constraintOfDisease Values('Deep fried',43)
Insert into constraintOfDisease Values('baked meats',43)
Insert into constraintOfDisease Values('Excessive salt',43)
Insert into constraintOfDisease Values('oily foods',43)

Insert into constraintOfDisease Values('Caffeinated drinks',44)
Insert into constraintOfDisease Values('alcohol',44)
Insert into constraintOfDisease Values('Greasy foods',44)
Insert into constraintOfDisease Values('citrus juices',44)

Insert into constraintOfDisease Values('raw meat',45)
Insert into constraintOfDisease Values('dairy-based desserts',45)
Insert into constraintOfDisease Values('seafood',45)
Insert into constraintOfDisease Values('eggs',45)

Insert into constraintOfDisease Values('Fried foods',46)
Insert into constraintOfDisease Values('High-fat meats',46)
Insert into constraintOfDisease Values('fatty dairy products',46)
Insert into constraintOfDisease Values('Chocolate',46)
Insert into constraintOfDisease Values('Creamy soups, sauces',46)

Insert into constraintOfDisease Values('contaminated food',47)
Insert into constraintOfDisease Values('untreated water',47)
Insert into constraintOfDisease Values('raw vegetables',47)
Insert into constraintOfDisease Values('shellfish',47)
Insert into constraintOfDisease Values('ice',47)

Insert into constraintOfDisease Values('butter',48)
Insert into constraintOfDisease Values('fat dairy foods',48)
Insert into constraintOfDisease Values('Sugary treats is cookie, cake',48)
Insert into constraintOfDisease Values('heavily laced with salt',48)
Insert into constraintOfDisease Values('Alcohol',48)

Insert into constraintOfDisease Values('Raw oysters',49)
Insert into constraintOfDisease Values('shellfish',49)
Insert into constraintOfDisease Values('sugary foods',49)
Insert into constraintOfDisease Values('oilly foods',49)
Insert into constraintOfDisease Values('Salty foods',49)

Insert into constraintOfDisease Values('beef and lamb',50)
Insert into constraintOfDisease Values('Alcohol',50)
Insert into constraintOfDisease Values('Added sugar',50)
Insert into constraintOfDisease Values('Fried foods',50)
Insert into constraintOfDisease Values('Salty food and rice',50)



-------------------------------Inserting medicines-------------------------------------
DBCC CHECKIDENT ("dbo.Medicine", RESEED, 0);
--1 medicines for heart disease

delete from Medicine
insert into Medicine values('Aspirin',50)
insert into Medicine values('Altace',20)
select * from Medicine

--2 inserting medicines of crohons disease
insert into Medicine values('Rifaximin',50)
insert into Medicine values('Lubiprostone',20)

--3 inserting medicines of pancreasis
insert into Medicine values('Pancreatin',80)
insert into Medicine values('Albutein',25)

--4 inserting medicines of Lungs Disease
insert into Medicine values('Foradil',40)
insert into Medicine values('Todorza',30)
--5
insert into Medicine values('Donepezil',90)
insert into Medicine values('Galantamine',50)
--6
insert into Medicine values('Corticosteroid',99)
insert into Medicine values('hydrocortisone',80)
--7
insert into Medicine values('Adrenaline injections',99)
insert into Medicine values('epinephrine',80)
--8
insert into Medicine values('Fluticasone',99)
insert into Medicine values('Budesonide',80)
--9
insert into Medicine values('Zosyn',90)
insert into Medicine values('Unasyn',80)
--10
insert into Medicine values('Fluoxetine',90)
insert into Medicine values('Paroxetine',80)
--11
insert into Medicine values('Cytarabine',90)
insert into Medicine values('Anthracycline',80)
--12
insert into Medicine values('Fexofenadine',90)
insert into Medicine values('Loratadine',80)
--13
insert into Medicine values('Clobetasol propionate',90)
insert into Medicine values('Betamethasone dipropionate',80)
--14
insert into Medicine values('Olanzapine',90)
insert into Medicine values('Ziprasidone',80)
--15
insert into Medicine values('Olanzapine CF',90)
insert into Medicine values('Ziprasidone CF',80)
--16
insert into Medicine values('ceftriaxone',90)
insert into Medicine values('meropenem',80)
--17
insert into Medicine values('Doxorubicin',90)
insert into Medicine values('Cisplatin',80)
--18
insert into Medicine values('Avastin',90)
insert into Medicine values('Camptosar',80)
--19
insert into Medicine values('Diphenoxylate',90)
insert into Medicine values('Loperamide',80)
--20
insert into Medicine values('Afinitor',90)
insert into Medicine values('Bevacizumab',80)
--21
insert into Medicine values('Amoxicillin',90)
insert into Medicine values('Clarithromycin',80)
--22
insert into Medicine values('aspirinX',90)
insert into Medicine values('acetaminophen',80)
--23

select * from medicine
insert into Medicine values('fluoxetineX',90)
insert into Medicine values('citalopram',80)
--24
insert into Medicine values('AcetaminophenPY',90)
insert into Medicine values('ibuprofen',80)
--25
insert into Medicine values('decongestant',90)
insert into Medicine values('BudesonideXL',80)
--26
insert into Medicine values('AmoxicillinZY',90)
insert into Medicine values('IbuprofenSP',80)
--27
insert into Medicine values('doxycycline',90)
insert into Medicine values('AmoxicillinPH',80)
--28
insert into Medicine values('Nitroglycerin',90)
insert into Medicine values('Isosorbide dinitrate',80)
--29
insert into Medicine values('acyclovir',90)
insert into Medicine values('valacyclovir',80)
--30
insert into Medicine values('Nifedipine',90)
insert into Medicine values('corticosteroid cream',80)
--31
insert into Medicine values('Modafinil',90)
insert into Medicine values('Methylphenidate',80)
--32
insert into Medicine values('valacyclovirCr',90)
insert into Medicine values('Statins',80)
--33
insert into Medicine values('Bendamustine',90)
insert into Medicine values('Pentostatin',80)
--34
insert into Medicine values('azathioprine',90)
insert into Medicine values('budesonidePF',80)
--35
insert into Medicine values('acetaminophenZL',90)
insert into Medicine values('ibuprofenAd',80)
 --36
insert into Medicine values('nitrofurantoin',90)
insert into Medicine values('amoxicillinO',80)
 --37
insert into Medicine values('Oral rehydration',90)
insert into Medicine values('Pedialyte',80)
 --38
insert into Medicine values('Metformin',90)
insert into Medicine values('Insulin',80)
 --39
insert into Medicine values('glycerine',90)
insert into Medicine values('cetomacrogol',80)
 --40
insert into Medicine values('Trihexyphenidyl',90)
insert into Medicine values('Carbidopa-levodopa',80)
 --41
insert into Medicine values('REGN-EB3',90)
insert into Medicine values('mAb-114',80)
 --42
insert into Medicine values('Lamictal',90)
insert into Medicine values('valproic-acid',80)
 --43
insert into Medicine values('cyclophosphamide',90)
insert into Medicine values('doxorubicinCF',80)
 --44
insert into Medicine values('zanamivir',90)
insert into Medicine values('baloxavir',80)
 --45
insert into Medicine values('Bismuth subsalicylate',90)
insert into Medicine values('Azithromycin',80)
 --46
insert into Medicine values('ursodiol',90)
insert into Medicine values('chenodiol',80)
 --47
insert into Medicine values('acetaminophenY',90)
insert into Medicine values('analgesics',80)
 --48
insert into Medicine values('entecavir',90)
insert into Medicine values('tenofovir',80)
 --49
insert into Medicine values('Ledipasvir-sofosbuvir',90)
insert into Medicine values('sofosbuvir',80)
 --50
insert into Medicine values('Cabometyx',90)
insert into Medicine values('Keytruda',80)

select * from Medicine
select * from users


-----------------------------adding treatable disease by this medicines---------------------------

-- medID, disease, dosage, time, duration, MinAge, MaxAge

delete from treatableDiseaseByMedicine
select * from treatableDiseaseByMedicine
insert into  treatableDiseaseByMedicine values(1,1,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(1,1,500,3,10,13,65)
insert into  treatableDiseaseByMedicine values(2,1,500,1,5,13,60)

insert into  treatableDiseaseByMedicine values(3,2,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(3,2,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(4,2,500,2,13,0,14)

insert into  treatableDiseaseByMedicine values(5,3,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(5,3,500,3,10,13,65)
insert into  treatableDiseaseByMedicine values(6,3,100,3,30,7,60)

insert into  treatableDiseaseByMedicine values(7,4,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(7,4,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(8,4,500,2,30,14,60)

insert into  treatableDiseaseByMedicine values(9,5,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(9,5,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(10,5,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(11,6,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(11,6,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(12,6,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(13,7,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(13,7,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(14,7,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(15,8,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(15,8,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(16,8,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(17,9,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(17,9,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(18,9,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(19,10,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(19,10,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(20,10,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(21,11,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(21,11,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(22,11,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(23,12,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(23,12,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(24,12,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(25,13,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(25,13,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(26,13,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(27,14,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(27,14,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(28,14,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(29,15,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(29,15,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(30,15,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(31,16,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(31,16,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(32,16,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(33,17,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(33,17,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(34,17,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(35,18,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(35,18,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(36,18,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(37,19,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(37,19,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(38,19,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(39,20,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(39,20,500,3,10,13,60)
insert into  treatableDiseaseByMedicine values(40,20,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(41,21,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(41,21,500,3,10,13,65)
insert into  treatableDiseaseByMedicine values(42,21,500,2,12,18,60)

insert into  treatableDiseaseByMedicine values(43,22,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(43,22,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(44,22,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(45,23,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(45,23,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(46,23,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(47,24,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(47,24,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(48,24,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(49,25,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(49,25,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(50,25,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(51,26,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(51,26,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(52,26,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(53,27,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(53,27,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(54,27,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(55,28,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(55,28,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(56,28,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(57,29,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(57,29,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(58,29,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(59,30,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(59,30,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(60,30,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(61,31,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(61,31,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(62,31,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(63,32,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(63,32,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(64,32,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(65,33,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(65,33,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(66,33,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(67,34,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(67,34,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(68,34,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(69,35,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(69,35,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(70,35,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(71,36,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(71,36,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(72,36,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(73,37,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(73,37,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(74,37,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(75,38,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(75,38,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(76,38,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(77,39,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(77,39,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(78,39,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(79,40,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(79,40,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(80,40,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(81,41,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(81,41,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(82,41,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(83,42,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(83,42,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(84,42,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(85,43,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(85,43,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(86,43,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(87,44,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(87,44,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(88,44,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(89,45,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(89,45,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(90,45,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(91,46,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(91,46,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(92,46,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(93,47,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(93,47,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(94,47,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(95,48,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(95,48,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(96,48,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(97,49,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(97,49,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(98,49,500,2,12,18,65)

insert into  treatableDiseaseByMedicine values(99,50,250,2,7,0,12)
insert into  treatableDiseaseByMedicine values(99,50,500,3,10,13,100)
insert into  treatableDiseaseByMedicine values(100,50,500,2,12,18,65)

