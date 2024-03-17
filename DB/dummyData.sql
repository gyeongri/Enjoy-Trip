set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `comment`;
TRUNCATE TABLE my_place;
TRUNCATE TABLE `user`;
TRUNCATE TABLE my_plan;
TRUNCATE table `board`;


-- user,board,comment,my_plage,my_plan

-- user 더미데이터
INSERT INTO user (user_id, user_pwd, user_nickname) VALUES
('user1', 'password1', 'nickname1'),
('user2', 'password2', 'nickname2'),
('user3', 'password3', 'nickname3'),
('user4', 'password4', 'nickname4'),
('user5', 'password5', 'nickname5'),
('user6', 'password6', 'nickname6'),
('user7', 'password7', 'nickname7'),
('user8', 'password8', 'nickname8'),
('user9', 'password9', 'nickname9'),
('user10', 'password10', 'nickname10'),
('user11', 'password11', 'nickname11'),
('user12', 'password12', 'nickname12'),
('user13', 'password13', 'nickname13'),
('user14', 'password14', 'nickname14'),
('user15', 'password15', 'nickname15'),
('user16', 'password16', 'nickname16'),
('user17', 'password17', 'nickname17'),
('user18', 'password18', 'nickname18'),
('user19', 'password19', 'nickname19'),
('user20', 'password20', 'nickname20'),
('user21', 'password21', 'nickname21'),
('user22', 'password22', 'nickname22'),
('user23', 'password23', 'nickname23'),
('user24', 'password24', 'nickname24'),
('user25', 'password25', 'nickname25'),
('user26', 'password26', 'nickname26'),
('user27', 'password27', 'nickname27'),
('user28', 'password28', 'nickname28'),
('user29', 'password29', 'nickname29'),
('user30', 'password30', 'nickname30');


-- board 더미 데이터
INSERT INTO `board` (user_id, article_title, article_content) VALUES
-- ('user1', '겨울의 첨성대는 예쁘다', '서울의 첨성대는 겨울에 눈이 내리면 더 아름답습니다'),
('user1', '바다가 그리워지는 여행', '한적한 해변을 걷는 것은 마음을 편안하게 만듭니다.'),
('user1', '산과 자연 속으로', '자연 속으로 향하는 여행은 신선한 공기를 마시며 마음을 정화합니다.'),
('user2', '도시 속 오아시스', '도시 속 작은 오아시스를 발견하는 여행은 일상에서 벗어나 새로운 경험을 만듭니다.'),
('user2', '여유로운 시간을 위한 여행', '스트레스 받는 일상을 떠나 여유를 찾는 여행은 새로운 에너지를 불어넣어줍니다.'),
('user2', '자유롭게 떠나는 여행', '자유롭게 떠나는 여행은 새로운 발견과 경험을 가져다줍니다.'),
('user3', '여행의 끝은 새로운 시작', '여행을 마치면 돌아오는 것이 아니라 새로운 시작입니다.'),
('user3', '모험과 함께하는 여행', '모험을 찾아 떠나는 여행은 잊지 못할 추억을 만들어줍니다.'),
('user3', '자연 속 소중한 시간', '자연 속에서 보내는 소중한 시간은 인생을 더 풍요롭게 만들어줍니다.'),
('user4', '꿈꾸던 여행', '꿈꾸던 여행지를 방문하면서 새로운 세계를 만나보세요.'),
('user4', '언제나 가고 싶은 곳', '마음속 언제나 가고 싶은 곳을 여행으로 떠나보세요.'),
('user4', '여행의 매력', '새로운 사람들을 만나며 여행은 더욱 풍요로워집니다.'),
('user5', '여행으로 세계를 탐험하다', '여행은 세계를 탐험하는 기회입니다. 새로운 문화와 경험을 만나보세요.');


-- comment 더미 데이터
INSERT INTO `comment` (user_id, comment_content, article_no) VALUES
('user1', '풍경이 정말 아름다워요!', '1'),
('user2', '날씨는 어땠나요?', '2'),
('user3', '여행 재밌었나요?', '3'),
('user4', '그곳은 어떤 분위기인가요?', '4'),
('user5', '다음에 꼭 가보고 싶네요!', '5'),
('user6', '힐링되는 여행이었나요?', '1'),
('user7', '가족 여행이었나요?', '2'),
('user8', '그곳의 매력을 잘 전달하셨네요!', '3'),
('user9', '그곳은 어떤 음식이 유명한가요?', '4'),
('user10', '여행의 추억을 오래 간직하세요.', '5'),
('user11', '여행이 곧 행복이죠!', '1'),
('user12', '그곳에서 새로운 친구를 만나셨나요?', '2'),
('user13', '여행의 가치를 다시금 느껴봅니다.', '3'),
('user14', '그곳은 사진 찍기 좋은 곳인가요?', '4'),
('user15', '마음이 따뜻해지는 여행이었나요?', '5'),
('user16', '그곳에서의 경험을 소중히 하세요.', '1'),
('user17', '여행 중 가장 기억에 남는 순간은 무엇이었나요?', '2'),
('user18', '그곳은 자연이 아름다운 곳이에요.', '3'),
('user19', '여행이 삶에 활력을 줄 수 있죠!', '4'),
('user20', '그곳에서의 경치가 정말 멋있어 보이네요!', '5'),
('user21', '여행이 힐링되는 시간이 되셨길 바랍니다.', '1'),
('user22', '여행 후기를 듣고 싶어요!', '2'),
('user23', '그곳의 문화가 흥미로워 보입니다.', '3'),
('user24', '여행에서 가장 중요한 건 무엇인가요?', '4'),
('user25', '그곳에서의 추억이 오래 간직되길 바라요.', '5'),
('user26', '여행이 행복을 주는 법입니다!', '1'),
('user27', '그곳의 사람들은 친절하셨나요?', '2'),
('user28', '여행이 새로운 마음을 선물합니다.', '3'),
('user29', '그곳에서의 여행이 생각나면 미소지을 거예요.', '4'),
('user30', '여행을 통해 더 많은 것을 알게 되었나요?', '5');




