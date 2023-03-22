insert into MEMBER (MEMBER_ID, PWD, ROLE_GROUP) values ('adv', '$2a$12$MgEeHQnarEOaP4YmxICz1eGp2BRkdvFirHVHGmAaWIDR4hKiItVum', 'ROLE_ADV');
insert into MEMBER (MEMBER_ID, PWD, ROLE_GROUP) values ('admin', '$2a$12$5gAfweaYifUjut.wYjcghef9bkAUiccQaLkU6O3dUWlcmRnK.Hue.', 'ROLE_ADMIN');

insert into ADV (ADV_ID, AD_ING_ACT_YN, BALANCE, EVENT_MONEY, DAY_LIMIT_BUDGET) values ('adv', 1, 1000000, 0, 0);

insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB01', '신발1', 1, 10000, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB02', '신발2', 0, 5000, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB03', '아우터1', 1, 4000, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB04', '아우터2', 0, 3000, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB05', '바지1', 0, 100, 0);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB06', '바지2', 1, 200, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB07', '모자1', 0, 300, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB08', '모자2', 1, 400, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB09', '기타1', 1, 500, 1);
insert into ITEM(ITEM_NO, ITEM_NAME, ADULT_YN, ITEM_ORG_COST, ITEM_ACT_YN) values('NBS_DB10', '기타2', 1, 60000, 1);

insert into AGROUP(AGROUP_NAME, REG_TIME, AGROUP_ACT_YN, AGROUP_USE_CONFIG_YN) values('신발그룹', CURRENT_TIMESTAMP, 1, 1);
insert into AGROUP(AGROUP_NAME, REG_TIME, AGROUP_ACT_YN, AGROUP_USE_CONFIG_YN) values('아우터그룹', CURRENT_TIMESTAMP, 1, 1);
insert into AGROUP(AGROUP_NAME, REG_TIME, AGROUP_ACT_YN, AGROUP_USE_CONFIG_YN) values('바지그룹', CURRENT_TIMESTAMP, 1, 1);
insert into AGROUP(AGROUP_NAME, REG_TIME, AGROUP_ACT_YN, AGROUP_USE_CONFIG_YN) values('모자그룹', CURRENT_TIMESTAMP, 1, 1);
insert into AGROUP(AGROUP_NAME, REG_TIME, AGROUP_ACT_YN, AGROUP_USE_CONFIG_YN) values('기타그룹', CURRENT_TIMESTAMP, 1, 1);

insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(1, 1, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(1, 2, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(2, 3, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(2, 4, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(3, 5, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(3, 6, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(4, 7, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(4, 8, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(5, 9, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(5, 10, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(1, 3, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(1, 4, 1, CURRENT_TIMESTAMP, 1, 'adv');
insert into AD(AGROUP_ID, ITEM_ID, AD_USE_CONFIG_YN, REG_TIME, AD_ACT_YN, ADV_ID) values(1, 5, 1, CURRENT_TIMESTAMP, 1, 'adv');

insert into KWD(KWD_NAME, SELL_POSS_KWD_YN, MANUAL_CNR_KWD_YN) values('나이키', 1, 1);
insert into KWD(KWD_NAME, SELL_POSS_KWD_YN, MANUAL_CNR_KWD_YN) values('아디다스', 1, 1);
insert into KWD(KWD_NAME, SELL_POSS_KWD_YN, MANUAL_CNR_KWD_YN) values('리복', 1, 1);
insert into KWD(KWD_NAME, SELL_POSS_KWD_YN, MANUAL_CNR_KWD_YN) values('골든구스', 1, 1);
insert into KWD(KWD_NAME, SELL_POSS_KWD_YN, MANUAL_CNR_KWD_YN) values('살로몬', 1, 1);

insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(1, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(2, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(3, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(4, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(5, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(6, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(7, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(8, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(9, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(10, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(11, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(12, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(13, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(14, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(15, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');
insert into CNR_REQ(DAD_DET_ID, CNR_ING_STATUS, CNR_INPUT_DIV, CNR_REQ_TIME, CNR_PROC_TIME, CNR_COMPLETE_YN, CNR_FAIL_CAUSE, CNR_FAIL_COMT) values(16, 'READY', 'INPUT_CNR', CURRENT_TIMESTAMP,
                                                                                                                                                   CURRENT_TIMESTAMP, 0, '', '');

insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(1, 1, 'APPROVAL', 1, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(2, 2, 'APPROVAL', 2, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(3, 3, 'APPROVAL', 3, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(4, 4, 'APPROVAL', 4, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(5, 5, 'APPROVAL', 5, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(6, 1, 'APPROVAL', 6, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(7, 2, 'APPROVAL', 7, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(8, 3, 'APPROVAL', 8, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(9, 4, 'APPROVAL', 9, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(10, 5, 'APPROVAL', 10, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(11, 1, 'APPROVAL', 11, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(12, 2, 'APPROVAL', 12, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(13, 3, 'APPROVAL', 13, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(1, 2, 'APPROVAL', 14, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(1, 3, 'APPROVAL', 15, 1, 1, CURRENT_TIMESTAMP);
insert into DAD_DET(AD_ID, KWD_ID, DAD_CNR_STATUS, CNR_REQ_ID, DAD_USE_CONFIG_YN, DAD_ACT_YN, REG_TIME) values(1, 4, 'APPROVAL', 16, 1, 1, CURRENT_TIMESTAMP);

insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(1, 100);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(2, 200);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(3, 300);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(4, 400);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(5, 500);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(6, 600);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(7, 700);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(8, 800);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(9, 900);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(10, 1000);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(11, 1100);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(12, 1200);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(13, 1300);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(14, 1400);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(15, 1500);
insert into DAD_DET_BID(DAD_DET_ID, BID_COST) values(16, 1600);
