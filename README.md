
1.	На основе имеющейся ERD создать базу данных.(Открывать через https://www.draw.io/)
2.	Внести тестовые данные (от 2 до 5 записей для таблицы).
3.	Разработать приложение (Spring Boot) для доступа к созданной базе данных с помощью Rest API в формате json.
4.	Составьте алгоритм разбора адресной строки, осуществляющий поиск по данной БД, возвращающий в результате либо идентификатор дома, 
либо сообщение о его отсутствии в базе данных. Адрес может быть написан в произвольной форме. (GetMapping("/address/{address}"))

Приложение.
 На основе имеющихся данных в БД создать следующие методы Rest API:
1.	/cities – перечень городов с указанием количества домов
2.	/streets – перечень улиц с указанием количества домов с запросом по городу  /streets?city_id={city_id} 
3.	/houses – перечень домов с указанием полного адреса и количества квартир с запросом по конкретной улице / городу  /houses?city_id={city_id} и /houses? street_id={street_id}


Описание БД.
1.	Таблица Apartments(Квартиры)
•	id.
•	house_id – id дома в котором находится квартира.
•	area - площадь квартиры.
2.	Таблица Houses(Дома)
•	id.
•	number - номер дома.
•	street_id – id улицы, на которой расположен дом.
3.	Таблица Streets(Улицы)
•	id.
•	name - наименование улицы.
•	city_id – id города, в котором находится улица.
4.	Таблица Cities(Города)
•	Id.
•	name - Наименование города.
 
