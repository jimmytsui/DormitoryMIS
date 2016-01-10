create table 学生(
学号 varchar(20) primary key,
姓名 varchar(20),
所在班级 varchar(20)
);

select * from 学生

create table 宿舍(
寝室号 varchar(20) primary key,
应住人数 int,
实住人数 int
);

select * from 宿舍

create table 入住(
学号 varchar(20),
寝室号 varchar(20),
床位号 int,
primary key(学号,寝室号),
foreign key (学号) references 学生(学号),
foreign key (寝室号) references 宿舍(寝室号)
);

select * from 入住

create table 管理(
id SERIAL primary key,
学号 varchar(20),
寝室号 varchar(20),
扣分 int,
日期 date,
foreign key (学号) references 学生(学号),
foreign key (寝室号) references 宿舍(寝室号)
);

CREATE OR REPLACE FUNCTION checkin(sno varchar(50),dno varchar(50),bno int)
RETURNS INT AS
$$
DECLARE
snoSCnt INT;
SnoDCnt INT;
DmiCnt  INT;
PMax    INT;
NPeo    INT;
BEGIN
  SELECT COUNT(*) INTO snoSCNT FROM 学生 WHERE 学号=sno;
   IF(snoSCNT=0) THEN --判断是否存在该学生
     RETURN -1;
   END IF;
   SELECT COUNT(*) INTO SnoDCnt FROM 入住 WHERE 学号=sno;
   IF(SnoDCnt!=0) THEN --判断该学生是否入住
     RETURN -4;
   END IF;
   SELECT COUNT(*) INTO PMax FROM 宿舍 WHERE 寝室号=dno AND 实住人数<应住人数;
   IF(PMax=0) THEN --寝室已满
     RETURN -2;
   END IF;
   SELECT COUNT(*) INTO DmiCnt FROM 入住 WHERE 床位号=bno AND 寝室号=dno;
   IF(DmiCnt!=0) THEN  --该床位被占用或者无该寝室
     RETURN -3;
   END IF;
   SELECT 实住人数 INTO NPeo FROM 宿舍 WHERE 寝室号=dno; --获取寝室人数
   UPDATE 宿舍 SET 实住人数=NPeo+1 WHERE 寝室号=dno; --寝室人数更新
   INSERT INTO 入住 values(sno,dno,bno); --插入操作
   
   RETURN 1;
END;
$$ LANGUAGE plpgsql;
