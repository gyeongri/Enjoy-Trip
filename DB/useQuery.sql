-- 사용한 쿼리문

-- 회원가입
insert into `user` (user_id,user_pwd,user_nickname)
values ('ssafy','1234','싸피','ssafy');

-- 회원탈퇴
update user set delete_yn=1, refresh_token=null
where user_id='3';

-- 로그인
select user_id, refresh_token
from user
where user_id = 'ssafy' and user_pwd = '1234'
and delete_yn = 0;

-- 리프레쉬 토큰 저장
update user
set refresh_token = '12345'
where user_id = 'ssafy';

-- 리프레쉬 토큰 얻기
select refresh_token
from user
where user_id = 'ssafy';

-- 리프레쉬 토큰 삭제
update user
set refresh_token = null
where user_id = 'ssafy';

-- 글 리스트 가져오기
select b.article_type, b.article_no, b.article_title, u.user_nickname, b.article_hit, b.article_register_time
from board b join user u
on b.user_id=u.user_id
and article_title like concat('%', 'wow', '%')
order by b.article_no desc
limit 1,20;

-- 전체 글 수 세기
select count(article_no)
from board,user u;

-- 글쓰기
insert into `board` (user_id,article_title,article_content)
values ('ssafy','안녕하세요?','하하');

-- 글수정
update board
set article_title ='안녕', article_content = '반갑습니다'
where article_no = '1';

-- 글 삭제
delete from board
where article_no = '1';

-- 조회수 업데이트
update board
set article_hit = article_hit + 1
where article_no ='1';

-- 댓글 목록 가져오기
select c.comment_no, u.user_nickname, c.comment_content,c.comment_register_time
from comment c join board b join user u
on c.article_no=b.article_no and u.user_id=c.user_id
where b.article_no = '1'
order by comment_register_time;

-- 댓글쓰기
insert into comment (user_id, comment_content, comment_register_time, article_no)
values ('ssafy', '싸피댓글', now(), '1');

-- 댓글 삭제
delete from comment
where comment_no ='1';

-- 컨텐츠 타입 가져오기
select distinct content_type_id
from attraction_info
order by content_type_id

-- 시도 가져오기
select sido_code, sido_name
from sido
order by sido_code;

-- 구군 가져오기
select gugun_code, gugun_name
from gugun
where sido_code = '1'
order by gugun_code;
-- 관광지 정보 가져오기
select content_id, content_type_id, title, addr1, addr2,
first_image, first_image2, sido_code, gugun_code, latitude, longitude,
mlevel, readcount, tel, zipcode
from attraction_info
where content_type_id = '12' and sido_code ='1' and gugun_code = '1'
order by gugun_code;
