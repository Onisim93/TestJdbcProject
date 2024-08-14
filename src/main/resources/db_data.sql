INSERT INTO authors (name, bio) VALUES
('Пушкин Александр Сергеевич', 'Годы жизни 1799-1837. Александр Сергеевич Пушкин - великий русский поэт, драматург и прозаик, считающийся основателем современной русской литературы. Родился в Москве в дворянской семье. Воспитывался в духе европейского Просвещения. Известен своими произведениями, такими как “Евгений Онегин”, “Руслан и Людмила”, “Капитанская дочка”. Пушкин был участником декабристского движения и вел активную литературную и общественную деятельность до своей трагической гибели на дуэли в 1837 году.'),
('Толстой Лев Николаевич', 'Годы жизни 1828-1910. Лев Николаевич Толстой - один из самых известных русских писателей и философов, автор романов “Война и мир”, “Анна Каренина” и “Воскресение”. Родился в Тульской губернии в аристократической семье. Получил образование в Казанском университете. Толстой также известен своими религиозными и философскими трудами. В последние годы жизни отказался от своего богатства и стал вести скромный образ жизни, что вызвало широкий общественный резонанс.'),
('Достоевский Федор Михайлович', 'Годы жизни 1821-1881. Федор Михайлович Достоевский - выдающийся русский писатель, философ и публицист, автор таких произведений, как “Преступление и наказание”, “Идиот”, “Братья Карамазовы” и “Бесы”. Родился в Москве в семье врача. В молодости был арестован за участие в революционном кружке и сослан в Сибирь. Творчество Достоевского глубоко исследует человеческую природу и нравственные дилеммы.'),
('Чехов Антон Павлович', 'Годы жизни 1860-1904. Антон Павлович Чехов - знаменитый русский драматург и прозаик, признанный мастер короткого рассказа. Родился в Таганроге в семье торговца. Получил медицинское образование в Московском университете. Среди его наиболее известных пьес “Вишневый сад”, “Три сестры”, “Чайка”. Чехов также написал множество коротких рассказов, исследующих человеческие отношения и социальные проблемы.'),
('Пастернак Борис Леонидович', 'Годы жизни 1890-1960. Борис Леонидович Пастернак - русский поэт, писатель и переводчик, лауреат Нобелевской премии по литературе 1958 года. Родился в Москве в творческой семье художника и пианистки. Учился в Московском университете. Наибольшую известность получил его роман “Доктор Живаго”, за который он был удостоен Нобелевской премии, но был вынужден отказаться от нее под давлением советских властей. Пастернак также известен своими поэтическими сборниками и переводами классических произведений мировой литературы на русский язык.');

INSERT INTO genres (name, description) VALUES
('Поэма', 'Поэма - литературный жанр, в котором соединяются черты лирического и эпического родов. Так, от эпоса поэма наследует повествование о событиях, проблематику, образы персонажей, а от лирики – яркую эмоциональность изображения, сосредоточенность на чувствах и переживаниях главного героя.'),
('Драма', 'Драма - жанр литературы, повествующий о серьезных, иногда печальных событиях, но не заканчивающийся трагическим финалом. Драму по определению относят к серьезным жанрам литературы. В отличие от легкой литературы драма сосредоточена не на сюжете, а на переживаниях героев в обстоятельствах, предложенных сюжетом.'),
('Роман', 'Рома́н — литературный жанр, чаще прозаический, зародившийся в Средние века у романских народов, как рассказ на народном языке и ныне превратившийся в самый распространённый вид эпической литературы, изображающий жизнь персонажа с её волнующими страстями, борьбой, социальными противоречиями и стремлениями к идеалу.'),
('Роман в стихах', 'РОМА́Н В СТИХА́Х — лиро-эпический жанр, предполагающий соединение черт как эпоса, так и лирики в пределах одного произведения. Характерные черты романа в стихах: наличие сюжетной линии, системы персонажей, конфликта; способ отображения действительности (эпос).'),
('Исторический роман', 'Исторический роман — произведение художественной литературы, события которого разворачиваются на фоне исторических событий и с участием реальных исторических личностей. В историческом романе автор с помощью художественных средств описывает реальные исторические события, показывая их глазами действующих лиц.'),
('Русская сказка', 'Русская народная сказка (до XVII века баснь, байка) — эпическое художественное произведение русского народа, преимущественно прозаического, волшебного и авантюрного или бытового характера с установкой на вымысел (определение Э. В. Померанцевой); один из основных жанров фольклорной прозы.'),
('Сборник стихотворений', 'Сборник небольших поэтических произведений, написанных по законам стихосложения. Стихотворение – это жанр такого рода литературы, как лирика.'),
('Историческая повесть', 'Историческая повесть - жанр повествовательной литературы. В ней изображаются в художественной форме события и лица какого-нибудь исторического периода. Основные требования к исторической повести такие: в основе - исторические источники - архивы, летописи, прошлое -даже далёкое должно быть понятно читателю.'),
('Психологический Роман', 'Психологический роман — роман, центральное внимание в котором уделяется характерам персонажей, их душевным переживаниям и развитию. Сюжет в психологическом романе играет вспомогательную роль для раскрытия характеров героев, их трансформации и движений души.');


INSERT INTO books (title, description, published_date, isbn, author_id) VALUES
('Евгений Онегин', 'Основное произведение Пушкина, описывающее жизнь светского молодого человека Евгения Онегина и его взаимоотношения с Татьяной Лариной.', '1825-1832', '978-0140448030', 1),
('Руслан и Людмила', 'Эпическая поэма, основанная на народных русских сказках, повествует о похищении невесты Руслана - Людмилы, дочери князя Владимира.', '1820', '978-0486293356', 1),
('Капитанская дочка', 'Историческая повесть, описывающая события Крестьянской войны под предводительством Пугачева и историю любви Петра Гринева и Маши Мироновой.', '1836', '978-0140446753', 1),
('Война и мир', 'Эпическое произведение, описывающее жизнь русского общества во время Наполеоновских войн.', '1869', '978-1400079988', 2),
('Анна Каренина', 'Роман о трагической судьбе замужней женщины Анны Карениной, вступившей в любовные отношения с графом Вронским.', '1877', '978-0143035008', 2),
('Воскресение', 'Последний роман Толстого, рассказывающий о духовном пробуждении и искуплении князя Дмитрия Нехлюдова.', '1899', '978-0199536399', 2),
('Преступление и наказание', 'История о студенте Родионе Раскольникове, который совершает убийство и пытается оправдать его высшими целями.', '1866', '978-0140449136', 3),
('Идиот', 'Роман о князе Мышкине, который возвращается в Россию после лечения в Швейцарии и пытается жить по принципам добра и любви, сталкиваясь с жестокостью и непониманием.', '1869', '978-0140447927', 3),
('Братья Карамазовы', 'Роман, исследующий глубокие философские и нравственные вопросы через историю семьи Карамазовых.', '1880', '978-0374528379', 3),
('Вишневый сад', 'Пьеса о судьбе семьи Раневских, которая теряет свое имение и вишневый сад из-за финансовых проблем.', '1904', '978-0486266824', 4),
('Три сестры', 'Пьеса о трех сестрах Прозоровых, мечтающих вернуться в Москву и изменить свою жизнь.', '1901', '978-0486272801', 4),
('Чайка', 'Пьеса о сложных взаимоотношениях между членами творческой семьи и их знакомыми.', '1896', '978-0486408835', 4),
('Доктор Живаго', 'Роман о судьбе врача Юрия Живаго на фоне революции и Гражданской войны в России.', '1957', '978-0099448426', 5),
('Моя сестра - жизнь', 'Сборник поэзии, написанный в период революции, посвященный любви и природе.', '1922', '978-0810113551', 5),
('Земля', 'Поэтический сборник, включающий стихи, написанные в разные периоды жизни Пастернака и посвященные разным темам: любви, природе, философии.', '1956', '978-0810113550', 5);


INSERT INTO book_genres (book_id, genre_id) VALUES
(1, 4),
(2, 1),
(2, 6),
(3, 8),
(4, 5),
(5, 3),
(6, 3),
(7, 9),
(8, 3),
(9, 3),
(10, 2),
(11, 2),
(12, 2),
(13, 3),
(14, 7),
(15, 7),
(15, 2);

