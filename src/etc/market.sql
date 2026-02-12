drop database if exists market;
create database market;
use market;

create table product(
	pid int auto_increment,
    constraint primary key(pid),
    nick varchar(30) not null,
    pname varchar(30) not null,
    pcomment longtext not null,
    price int default 0,
    pwd varchar(10),
    pnumber char(13),
    state char(3) default "판매중"
);
INSERT INTO product (nick, pname, pcomment, price, pwd, pnumber, state) VALUES
('hanseung', '아이폰 14', '거의 새제품입니다. 박스 포함.', 850000, '1234', '2026021200011', '판매중'),

('minsu', '갤럭시 S23', '생활기스 약간 있습니다.', 650000, '1111', '2026021200012', '판매중'),

('jihye', '맥북 프로 M2', '1년 사용, 충전기 포함.', 1550000, '2222', '2026021200013', '판매완'),

('seojun', '에어팟 프로', '노이즈캔슬링 정상 작동.', 180000, '3333', '2026021200014', '판매중'),

('yuna', '닌텐도 스위치', '동물의 숲 에디션, 상태 좋음.', 300000, '4444', '2026021200015', '예약중');

select*from product;