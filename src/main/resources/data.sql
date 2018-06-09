insert into dbo.VehicleStates (id,state) 
values 
(1,'Vehiculo aguardando ingreso a planta'),
(2,'Vehiculo autorizado a entrar a planta'),
(3,'Vehiculo NO autorizado a entrar a planta'),
(4,'Vehiculo en planta'),
(5,'Vehiculo ha salido de la planta');


INSERT INTO dbo.CompanyType (Description,deleted)
VALUES
( 'Samseng (No necesita Autorizacion)',0 ),
( 'Transportes de mercaderia internacionales',0 ),
( 'Transportes de mercaderia nacionales',0 ),
( 'Transporte de residuos',0 );


INSERT INTO [dbo].[Company]
           ([CompaniesTypeId]
           ,[name]
           ,[taxesNumberID]
           ,[address]
           ,[telephone1]
           ,[email]
           ,[deleted])
     VALUES
           (1
           ,'Samseng SA'
           ,'30-65527599-8'
           ,'Av. Chorroarín 1121'
           ,'4588-8415'
           ,'info@papelerasamseng.com'
           ,0),
           
           (1
           ,'Tubosar SRL'
           ,'30-71148687-5'
           ,'Av. 101 9 de Julio 5670, Villa Ballester, Buenos Aires'
           ,'4769-7002'
           ,'info@tubosar.com'
           ,0),
           
           (2
           ,'HAMBURG SUD SUCURSAL ARGENTINA'
           ,'30-68893820-8'
           ,'RP195 1969, Vicente López, Buenos Aires'
           ,'5789-9900'
           ,'info@hamburgsur.com'
           ,0),
           (2
           ,'LTM Logística Total Mercosur'
           ,'30-70898927-0'
           ,'Chile 537, 1098 CABA'
           ,'4307-7878'
           ,'info@ltm.com'
           ,0),
           (2
           ,'Transporte Borreguito  - de Marvi S.R.L.'
           ,'30-67703122-7'
           ,'Ramón Ferrate 257 (Alt. Juan B. Justo 8500) Cordoba'
           ,' (54 - 351) 4995635'
           ,'info@borrego.com'
           ,0),
           
           (3
           ,'LA ARGENTINA'
           ,'30-68893820-8'
           ,'Pedro bueno 1777'
           ,'5781-9100'
           ,'info@argentina.com'
           ,0),
           (3
           ,'LTA Logística Total Argentina'
           ,'31-78898927-0'
           ,'Argentina 1537, 1986 CABA'
           ,'4307-7871'
           ,'info@lta.com'
           ,0),
           (3
           ,'Transportadora Argentina - de Cris S.R.L.'
           ,'30-67703212-7'
           ,'Av la plata 1030  Salta'
           ,'(54 - 811) 4395635'
           ,'info@tarsa.com'
           ,0),
           
           (4
           ,'Crieco'
           ,'32-87703212-7'
           ,'25 de Mayo 1627 1º Piso - San Martín (B1650BJA)'
           ,'4755-752'
           ,'info@crieco.com.ar'
           ,0)
           ;

INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(1,5162392,'Randall Campos','2018-07-14','2017-10-29','65884716','15571548','759-4221',0),(4,5780669,'Arsenio Weber','2018-08-15','2018-12-19','21511414','66935268','376-6040',0),(8,5326054,'Jack Guzman','2018-03-21','2019-02-17','48835439','37142192','374-0975',0),(7,1956804,'Edan Rosa','2018-05-18','2017-09-28','94112322','91683426','828-6764',0),(4,7854015,'Amela Henderson','2017-09-12','2017-12-23','31911492','27662998','656-7280',0),(7,566538,'Hayes Parrish','2018-01-07','2017-12-01','91474945','71707379','287-4374',0),(6,371524,'Jaden Hutchinson','2018-11-26','2018-07-22','54520902','40438085','931-5481',0),(4,7465317,'Blossom Pierce','2018-01-09','2017-06-17','79255288','94212518','289-6232',0),(1,6144093,'Hayes Singleton','2017-08-11','2017-09-29','52592049','27980247','236-9716',0),(8,2158991,'Daphne Carpenter','2019-02-04','2017-11-24','28232299','53745625','137-7486',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(9,7403996,'Celeste Morales','2017-10-02','2017-12-01','38053767','20984627','733-9730',0),(3,4652847,'Quail Holloway','2017-06-30','2019-03-09','23548841','71954794','199-0178',0),(8,4788910,'Valentine Rosales','2018-09-16','2018-12-28','90796729','22574233','135-9652',0),(3,6356565,'Vielka Cotton','2017-10-20','2017-08-16','57215681','42184063','541-2294',0),(6,984803,'Jessica Nielsen','2019-05-22','2018-05-24','49217384','63204194','485-2248',0),(3,4635807,'Brody Gregory','2018-05-04','2019-02-13','24730288','43406781','836-5665',0),(4,9884267,'Hilary Melton','2018-11-17','2018-05-26','65577445','16724458','742-1130',0),(9,5839252,'Bradley Goff','2019-05-13','2018-11-15','95579908','31538852','523-3680',0),(5,286862,'Plato Gill','2018-04-13','2019-04-23','27778309','00572346','880-5899',0),(2,4796819,'Sacha Bridges','2018-03-22','2018-08-31','99113277','10021107','781-8917',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(3,1915820,'Wyoming Dale','2019-05-07','2017-08-13','35624358','01343577','597-0445',0),(7,1794015,'Drake Oliver','2018-07-29','2019-03-29','59143304','87162030','890-6763',0),(5,5069461,'Brett Solomon','2019-02-10','2017-07-22','47799366','29442349','996-0185',0),(1,2982562,'Nell Chambers','2018-04-27','2017-11-02','91631331','44756000','732-8645',0),(6,8729329,'Adrian Holman','2018-09-14','2018-11-11','62032354','42415145','816-2513',0),(2,7043211,'Carlos Humphrey','2018-07-14','2018-06-21','16141888','09318215','934-3172',0),(6,7512857,'Dillon Lawrence','2018-05-18','2018-09-08','40405462','56899725','345-8262',0),(7,2967487,'Ivana Waller','2019-01-18','2018-11-09','03781242','70495918','675-9153',0),(3,3299048,'Asher Crawford','2019-05-19','2018-01-25','32671205','58924263','283-9397',0),(2,8318466,'Bruce Chambers','2018-10-22','2018-09-05','26057315','33963369','166-6656',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(1,1696621,'Vivian Benjamin','2018-04-19','2017-11-07','68789560','89126036','672-8513',0),(3,6302678,'Kirby King','2017-09-21','2018-02-24','04944568','66855192','286-1927',0),(5,7835247,'Bree Church','2018-11-09','2018-07-31','80653902','82141208','301-5167',0),(1,1681038,'Akeem Leblanc','2018-08-13','2018-03-22','46970209','71335211','717-3577',0),(8,8916122,'Kirby Odonnell','2018-01-31','2017-10-29','36970609','53072220','512-4440',0),(6,5732485,'Jillian Lott','2017-07-08','2018-09-22','40794069','50790606','151-8831',0),(9,2884475,'Guinevere Stewart','2018-06-19','2018-01-31','61910455','42359412','166-0732',0),(3,712565,'Evangeline Herring','2018-08-01','2018-12-26','90071843','55110662','732-3889',0),(1,5608969,'Xavier Harmon','2018-01-02','2019-01-31','43311491','79203979','689-3840',0),(6,4163013,'Maxine Mccarthy','2018-12-07','2019-01-09','41156683','64659158','541-8626',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(2,8561556,'Lunea Navarro','2019-05-15','2018-06-24','57010127','17619494','563-1019',0),(6,1753991,'Lionel Wall','2019-04-18','2018-09-23','65991759','05191296','736-4242',0),(4,5217908,'Caesar Norton','2017-08-14','2018-08-05','43848135','31108755','651-2719',0),(8,1380378,'Ashton Winters','2019-06-07','2018-07-20','68641903','43684823','302-9536',0),(5,8051458,'Kevin Miranda','2019-03-10','2019-06-08','05449291','34764749','263-1496',0),(9,6699787,'Joshua Mcmillan','2018-05-22','2017-07-24','38761315','45848935','415-9588',0),(2,881023,'Emerson Gates','2018-12-14','2019-04-05','74773289','74541685','482-4997',0),(9,5838351,'Hoyt Dejesus','2019-02-16','2018-06-19','36052352','85188410','330-3580',0),(6,1592581,'Lionel Walsh','2018-01-09','2019-04-27','66867431','36193472','646-2421',0),(9,6106017,'Sloane Travis','2019-01-01','2018-07-02','29727940','38222861','759-8153',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(4,1835989,'Laith Neal','2017-12-27','2018-06-30','31296580','78350281','836-3855',0),(4,8759364,'Henry Harrington','2017-10-01','2018-02-24','67468212','93885894','163-2855',0),(5,9165731,'Darrel Maddox','2018-08-11','2019-04-26','60826828','03102544','743-3028',0),(7,5162416,'Robin Poole','2018-11-12','2018-04-02','38865502','84586806','499-6262',0),(7,8474652,'Justin Burton','2019-05-06','2018-02-28','81776680','55995732','786-9783',0),(6,8659521,'Kim Reeves','2019-02-18','2017-08-16','73844459','54319883','551-9043',0),(2,637170,'Miranda Garner','2018-01-26','2018-05-05','18125629','01303013','895-3674',0),(5,8044021,'Pearl Rutledge','2018-01-20','2018-10-11','42584884','22104561','796-9909',0),(3,1930904,'Lillian Riley','2018-08-14','2018-05-11','28064322','79087907','507-4080',0),(1,5512776,'Roanna Mcknight','2018-03-05','2019-01-30','53043011','62014947','599-1433',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(8,3520784,'Linda Morris','2017-12-02','2017-11-20','24832014','87873657','732-4614',0),(2,6739379,'Ginger Tillman','2019-05-25','2017-07-08','25509131','71735284','695-4668',0),(1,8838097,'Beau Daugherty','2017-11-22','2019-05-14','35780572','48195789','205-3572',0),(9,9582803,'Patience Hoover','2017-08-30','2018-06-13','76324891','41208221','648-9507',0),(8,4302676,'Kaden Orr','2019-03-23','2018-04-29','59464361','95210047','810-5394',0),(2,9610191,'Alea Holmes','2018-01-11','2017-09-04','68011495','94253496','221-0705',0),(5,3387873,'Francis Noble','2017-09-16','2019-02-14','07449577','42246887','121-9873',0),(4,3571802,'Vincent Pitts','2019-01-27','2018-05-03','52830990','87949476','579-3387',0),(9,7794068,'Illana Powell','2019-04-09','2018-06-24','06028002','14222711','901-2072',0),(1,2213142,'Melissa Valdez','2019-01-18','2018-02-08','13847396','15797377','511-5862',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(7,5143152,'Lamar Buchanan','2019-05-21','2017-07-31','09527492','38581231','483-6415',0),(7,8786411,'Lance Alvarez','2017-07-12','2019-05-23','40936316','34831816','481-3916',0),(3,8899809,'Chadwick Burt','2017-11-20','2019-05-08','75136631','18858978','385-3173',0),(1,9090747,'Dorothy Dickson','2017-07-25','2018-07-03','89637488','73319995','984-7169',0),(2,9808915,'Zoe Graves','2018-02-08','2018-10-17','97226210','20463300','134-2889',0),(1,5505880,'Zelda Mercado','2018-06-20','2019-03-27','36715414','36855205','270-8943',0),(8,5412232,'Ariana Franks','2017-07-25','2018-01-09','53841929','02781438','774-3556',0),(5,2772602,'Sacha Davis','2017-08-12','2017-06-26','78038160','53319457','591-2565',0),(6,1410475,'Courtney Freeman','2019-05-14','2018-07-27','74147347','98303807','494-8012',0),(3,535092,'Karyn Franklin','2018-01-05','2019-03-30','68710720','59987683','926-8363',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(4,3558253,'Dominic Ray','2018-11-13','2018-03-29','42618556','85537638','148-8840',0),(4,1700543,'Christopher Foreman','2018-04-02','2017-08-17','25604101','85968164','254-6155',0),(9,4910718,'Xenos Preston','2019-02-12','2017-06-11','21157596','04580516','339-2038',0),(4,2023078,'Vance Medina','2018-01-07','2018-10-03','69599575','45790085','272-6474',0),(4,3497947,'Clinton Powers','2019-04-14','2017-08-20','52021009','63699737','111-5673',0),(6,6220028,'Carissa Chandler','2018-12-23','2017-11-26','03623520','86172409','404-8009',0),(7,1111744,'Brenden Lane','2018-07-07','2017-10-14','41731050','89747176','238-9966',0),(5,8477056,'Whitney Welch','2017-12-17','2017-10-01','53707859','04357388','603-5331',0),(2,8144511,'James Sosa','2019-04-13','2019-04-01','78002807','26879197','631-6340',0),(8,6603194,'Jennifer Dale','2017-10-07','2018-07-17','81079930','21412565','605-4833',0);
INSERT INTO [dbo].[Driver]([CompanyId],[documentNumber],[name],[driverLicenceExpireDate],[assuranceWorkRiskExpireDate],[driverLicenceNumber],[AFIPData],[Telephone],[deleted]) VALUES(9,3152231,'Jada Maynard','2018-11-17','2019-04-14','10530671','01911974','130-8264',0),(9,1873903,'Laura Brock','2018-06-21','2018-11-09','15515635','67311886','210-0250',0),(1,5029520,'Jennifer Patrick','2018-11-11','2018-08-12','71621176','96170878','814-7080',0),(3,7667082,'Guy Blankenship','2018-04-17','2019-05-20','14705760','99391086','358-2715',0),(5,2164414,'Owen Cote','2019-03-02','2019-03-05','37934480','55595676','480-7783',0),(3,5245848,'Lydia Obrien','2018-08-09','2018-03-18','89447316','14859624','304-0491',0),(2,2891070,'Stacy Hahn','2017-08-23','2019-04-15','76968009','03210621','929-1184',0),(4,2609481,'Shellie Oliver','2018-06-28','2017-10-09','94946384','51790191','408-1254',0),(2,2172773,'Callie Franklin','2018-07-15','2018-05-11','19552276','82931582','513-6910',0),(1,2640402,'Halee Warner','2019-04-21','2019-01-19','58252718','12336529','114-5297',0);

INSERT INTO [dbo].[Briefing]
           ([shortDescription]
           ,[longDescription]
           ,[deleted])
     VALUES
           ('Camiones nacionales'
           ,'CheckList para camiones nacionales'
           ,0),
           ('Camiones internacionales'
           ,'CheckList para camiones internacionales'
           ,0),
           ('Transportes de residuos'
           ,'CheckList para camiones de residuos'
           ,0),
           ('Vehiculos particulares'
           ,'CheckList para vehiculos particulares'
           ,0);


INSERT INTO [dbo].[VehicleType]
           ([BriefingId]
           ,[description]
           ,[hasTrailer]
           ,[deleted])
     VALUES
           (1,
           'Camion nacional'
           ,0
           ,0),
           
           (2,
           'Camion internacional'
           ,0
           ,0),
           
           (3,
           'Camion residuos'
           ,0
           ,0),
           
           (4,
           'Auto particular'
           ,0
           ,0);
           
           
INSERT INTO [dbo].[BriefingQuestions]
           ([BriefingsId]
           ,[question]
           ,[deleted])
     VALUES
           (1
           ,'Solicitar y verificar CNT habilitado para camiones'
           ,0),
           (1
           ,'Solicitar y verificar Seguro'
           ,0),
           (1
           ,'Verificar cantidad ruedas eje(s) trasero(s)'
           ,0),
           (1
           ,'Verificar situacion general del vehiculo'
           ,0),
           
           
           (2
           ,'Solicitar y verificar permiso internacional de manejo'
           ,0),
           (2
           ,'Solicitar y verificar Seguro internacional'
           ,0),
           (2
           ,'Verificar cantidad ruedas eje(s) trasero(s)'
           ,0),
           (2
           ,'Verificar situacion general del vehiculo'
           ,0),
           
           (3
           ,'Solicitar y verificar CNT habilitado para camiones'
           ,0),
           (3
           ,'Solicitar y verificar Seguro'
           ,0),
           (3
           ,'Verificar cantidad ruedas eje(s) trasero(s)'
           ,0),
           (3
           ,'Verificar situacion general del vehiculo'
           ,0),
           (3
           ,'Solicitar permiso de transporte de residuos peligrosos'
           ,0),
           
           (4
           ,'Solicitar y verificar CNT'
           ,0)
           
           
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(9,2,'15706121',' AAA',1,0,0),(7,1,'99825671',' AAA',1,1,0),(4,4,'31065584',' AAA',1,0,0),(1,4,'28114820',' AAA',1,0,0),(4,3,'24329587',' AAA',1,1,0),(7,2,'48481281',' AAA',0,0,0),(9,1,'75147950',' AAA',0,0,0),(8,3,'45175676',' AAA',0,1,0),(8,1,'77917080',' AAA',0,0,0),(7,1,'75029315',' AAA',1,1,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(2,4,'92882949',' AAA',0,1,0),(2,2,'38598345',' AAA',1,1,0),(3,2,'23822111',' AAA',1,0,0),(9,1,'17331861',' AAA',0,1,0),(7,4,'84619177',' AAA',1,1,0),(8,4,'73007672',' AAA',0,1,0),(7,2,'42608349',' AAA',1,0,0),(4,3,'28729476',' AAA',1,0,0),(9,3,'05143010',' AAA',1,1,0),(6,2,'27084439',' AAA',1,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(3,2,'09769378',' AAA',1,1,0),(4,1,'80644652',' AAA',0,1,0),(3,2,'98132910',' AAA',0,1,0),(7,2,'97771738',' AAA',1,1,0),(6,2,'64070302',' AAA',1,0,0),(9,1,'69372562',' AAA',0,0,0),(6,3,'30645699',' AAA',1,0,0),(9,3,'26019432',' AAA',0,1,0),(5,2,'57144163',' AAA',1,0,0),(3,2,'65815842',' AAA',0,1,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(7,3,'96592109',' AAA',1,0,0),(3,4,'11048048',' AAA',1,0,0),(6,4,'49106454',' AAA',0,1,0),(9,4,'56127399',' AAA',1,1,0),(5,4,'90678386',' AAA',1,0,0),(9,2,'84627604',' AAA',1,0,0),(3,4,'59156157',' AAA',0,0,0),(9,2,'53993403',' AAA',0,1,0),(8,2,'20915542',' AAA',1,1,0),(1,2,'01672612',' AAA',1,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(1,3,'13865200',' AAA',1,1,0),(3,2,'60372778',' AAA',1,1,0),(2,2,'41148849',' AAA',0,0,0),(4,4,'68256795',' AAA',0,1,0),(1,1,'32674891',' AAA',1,1,0),(2,2,'86245832',' AAA',0,1,0),(1,1,'76297348',' AAA',0,0,0),(6,2,'12846525',' AAA',1,0,0),(1,3,'37084315',' AAA',1,0,0),(9,1,'69827772',' AAA',1,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(9,1,'56445047',' AAA',1,0,0),(7,3,'62768871',' AAA',1,0,0),(4,4,'55779149',' AAA',0,0,0),(3,1,'49719565',' AAA',0,1,0),(1,1,'70585509',' AAA',1,0,0),(3,1,'83439762',' AAA',0,1,0),(7,1,'83515251',' AAA',0,0,0),(8,1,'30163287',' AAA',0,0,0),(5,4,'30379181',' AAA',0,0,0),(8,4,'82316359',' AAA',0,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(3,3,'12903187',' AAA',1,0,0),(8,2,'98417871',' AAA',1,1,0),(1,4,'06823374',' AAA',1,0,0),(2,4,'26029083',' AAA',1,0,0),(7,4,'83892607',' AAA',0,1,0),(7,2,'25836694',' AAA',0,0,0),(8,4,'09459057',' AAA',1,1,0),(9,1,'89833366',' AAA',1,0,0),(2,4,'95644469',' AAA',1,1,0),(4,4,'78267469',' AAA',0,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(3,1,'42670811',' AAA',1,0,0),(5,3,'35590255',' AAA',1,0,0),(8,1,'35802958',' AAA',0,0,0),(7,1,'03829050',' AAA',1,0,0),(1,3,'97445849',' AAA',1,0,0),(9,2,'35506266',' AAA',0,0,0),(5,3,'08030120',' AAA',1,1,0),(8,2,'50232603',' AAA',1,0,0),(7,2,'30468481',' AAA',0,0,0),(8,4,'25994016',' AAA',1,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(1,1,'35232366',' AAA',0,0,0),(4,3,'61659682',' AAA',0,1,0),(1,4,'44969760',' AAA',1,0,0),(3,1,'01548912',' AAA',0,0,0),(6,3,'32954506',' AAA',1,0,0),(4,3,'06756898',' AAA',1,1,0),(5,3,'72985339',' AAA',0,1,0),(3,2,'28292467',' AAA',0,1,0),(2,1,'81395194',' AAA',0,0,0),(5,3,'65814148',' AAA',0,0,0);
INSERT INTO Vehicle([CompanyId],[VehicleTypeId],[vehicleId],[trailerId],[needAutorization],[permissionDenegated],[deleted]) VALUES(7,1,'25717328',' AAA',1,1,0),(7,3,'86689121',' AAA',1,0,0),(3,2,'55628351',' AAA',0,0,0),(7,2,'34668348',' AAA',0,0,0),(2,1,'67932463',' AAA',0,1,0),(2,2,'80334642',' AAA',0,0,0),(2,1,'16160428',' AAA',0,0,0),(3,3,'09474371',' AAA',0,1,0),(1,3,'10073132',' AAA',0,0,0),(5,1,'29299340',' AAA',1,0,0);
