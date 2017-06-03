Problem: 

Есть программный сервис “Room”, предоставляет функциональность:
Открыть дверь.
Закрыть дверь.
Проверить пуста ли комната за дверью.
Поместить в комнату абстрактны объект, в комнате может находиться только один объект.
Проверить какой объект сейчас в комнате.
Удалить из комнаты абстрактный объект.
Подписаться на нотификацию о помещении в комнату объекта, объект может быть помещен в комнату другим клиентом сервиса.
Пример интерфейса сервиса на Java:

interface IEventListener {
void onObjectInRoom(Object object);
}
interface Room {
void open();
void close();
boolean isEmpty() throws RoomClosedException;
Object getObject() throws RoomClosedException;
void addObject(Object object) throws RoomClosedException;
void removeObject() throws RoomClosedException;
void subscribe(IEventListener listener);
}

Need to:

Составить план тестирования сервиса (формат не ограничен, можно прозой, но обязательно: сроки тестирования
(даты на каждый сценарий) и входные и выходные критерии для начала тестирования сценариев).
Описать подробно два сценария тестирования, один из сценариев должен включать работу с оповещениями. 
Автоматизировать описанные сценарии с использованием любых инструментов автоматизированного тестирования.

Solution :
Technical requirements
Java version : 1.6 and higher
Maven version : 3.3 and higher
JUnit version : 4.11

How to start
In Console / Terminal:
mvn -P BasicTest test
