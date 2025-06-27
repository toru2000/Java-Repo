
insert into passengers_tbl(id,name,email,phone) values (1,'Andrew','andrew@gmail.com','092342342');
insert into passengers_tbl(id,name,email,phone) values (2,'William','william@gmail.com','098845345');
insert into passengers_tbl(id,name,email,phone) values (3,'Kelvin','kelvin@gmail.com','09332222');
insert into passengers_tbl(id,name,email,phone) values (4,'Samlew','samlew@gmail.com','0933434343');
insert into passengers_tbl(id,name,email,phone) values (5,'Arnel','arnel@gmail.com','0986734343');

insert into addresses_tbl(state,township,street) values ('Mandalay','Maharmyaing','37st bet 68 and 69');
insert into addresses_tbl(state,township,street) values ('Mandalay','ChanMyaTharZi','102st bet 68 and 69');
insert into addresses_tbl(state,township,street) values ('Mandalay','AungMyayTharZan','19st bet 72 and 73');
insert into addresses_tbl(state,township,street) values ('Yangon','Yankin','no12 third floor');
insert into addresses_tbl(state,township,street) values ('Yangon','Sanchaung','n0122 second floor');

insert into licences_tbl(id,licenceNumber,licenceType,bloodType,dob,issueDate,validDate)values(1,'AA34333','C','A','1990-10-11','2006-11-21','2011-10-12');
insert into licences_tbl(id,licenceNumber,licenceType,bloodType,dob,issueDate,validDate)values(2,'AB43222','C','B','1991-05-21','2008-11-21','2011-10-12');
insert into licences_tbl(id,licenceNumber,licenceType,bloodType,dob,issueDate,validDate)values(3,'AA21212','D','AB','1990-10-04','2009-01-21','2014-01-21');
insert into licences_tbl(id,licenceNumber,licenceType,bloodType,dob,issueDate,validDate)values(4,'AC32323','D','O','1990-07-20','2007-01-11','2012-01-11');
insert into licences_tbl(id,licenceNumber,licenceType,bloodType,dob,issueDate,validDate)values(5,'BB23234','E','O','1990-10-11','2008-05-21','2013-05-21');

insert into drivers_tbl(id,name,gender,email,phone,addresses_id,licences_id)values(1,'AungKo','MALE','aungko@gmail.com','09222222',1,1);
insert into drivers_tbl(id,name,gender,email,phone,addresses_id,licences_id)values(2,'MyoThu','MALE','myothu@gmail.com','09343442',2,2);
insert into drivers_tbl(id,name,gender,email,phone,addresses_id,licences_id)values(3,'SanSanOo','FEMALE','sansan@gmail.com','092121288',3,3);
insert into drivers_tbl(id,name,gender,email,phone,addresses_id,licences_id)values(4,'Wanna','MALE','wanna@gmail.com','09542342',4,4);
insert into drivers_tbl(id,name,gender,email,phone,addresses_id,licences_id)values(5,'Zarni','MALE','zarni@gmail.com','0988777434',5,5);

insert into payments_tbl(id,amount,paymentType)values(1,5000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(2,15000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(3,20000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(4,7000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(5,6000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(6,8000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(7,95000,'WAVE');
insert into payments_tbl(id,amount,paymentType)values(8,12000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(9,5000,'KPAY');
insert into payments_tbl(id,amount,paymentType)values(10,5000,'KPAY');


insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(1,1,1,'start from a','end to b');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(1,2,2,'start from a','end to c');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(1,2,3,'start from a','end to b');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(2,2,4,'start from b','end to c');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(3,3,5,'start from a','end to c');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(3,3,6,'start from a','end to d');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(4,2,7,'start from b','end to e');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(5,1,8,'start from a','end to f');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(5,1,9,'start from a','end to b');
insert into trips_tbl(drivers_id,passengers_id,payments_id,startPoint,endPoint)values(1,5,10,'start from a','end to c');