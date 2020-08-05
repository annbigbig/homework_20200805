# Build Restful API with Spring5 + Hibernate 5

**Note:** all of codes in this repository were only for my personal practice purposes, some design patterns maybe not so correct, DO NOT use it as your tutorial

**注意:** 這裡的所有代碼只是我拿來自我練習，裡面許多設計模式也許不那麼正確，請勿拿來當你的編程教材

## Requirements
Develop couples Restful APIs for basic CRUD operation , and search data by keyword  
related HTTP verbs and API endpoints are as follows :

設計一組 Restful API 讓使用者完成簡易的CRUD操作及關鍵字模糊搜尋    
使用的HTTP verbs 與 API 端點如下:
- GET  https://yourdomain.com/rest/employee/get/{id}
- GET  https://yourdomain.com/rest/employee/getAll
- GET  https://yourdomain.com/rest/employee/search/{name}
- POST  https://yourdomain.com/rest/employee/create
- PUT  https://yourdomain.com/rest/employee/update/{id}
- DELETE  https://yourdomain.com/rest/employee/delete/{id}

## How to build this project ?

Via Maven command:

``` bash
$ mvn clean
$ mvn package
```
then you will find apiez01.war in target sub-directory  


## Database Structure  
don't worry about the database structure , Hibernate will generate a table for you,  
it's a simple table called 'TB_EMPLOYEE' , as its name, it stores some mock employees data  
database table structure like this :  

不要擔心底層資料表的結構 , HIbernate會為你產生它,  
是一個簡單的資料表叫做 'TB_EMPLOYEE' , 如它的表名 , 它會用來儲存一些假員工的資料  

``` 
MariaDB [db_spring]> desc TB_EMPLOYEE;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int(11)      | NO   | PRI | NULL    | auto_increment |
| address     | varchar(255) | NO   |     | NULL    |                |
| birthday    | date         | NO   |     | NULL    |                |
| luckyNumber | int(11)      | NO   |     | NULL    |                |
| name        | varchar(255) | NO   | MUL | NULL    |                |
| status      | tinyint(4)   | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
6 rows in set (0.002 sec)

```

## How to comsume API ? Try it on dq5rocks.com  && ScreenShot

不要忘記把 'http://localhost:8080' 換成 'https://www.dq5rockcs.com' 喔  
don't forget replace 'http://localhost:8080' with 'https://www.dq5rockcs.com'  

Create 4 users :  
![Create Employee 1](https://www.dq5rocks.com/images/create_employee_01.jpg?raw=true "Title")  
![Create Employee 2](https://www.dq5rocks.com/images/create_employee_02.jpg?raw=true "Title")  
![Create Employee 3](https://www.dq5rocks.com/images/create_employee_03.jpg?raw=true "Title")  
![Create Employee 4](https://www.dq5rocks.com/images/create_employee_04.jpg?raw=true "Title")  
  
  
Try to get them all back : 
![Get All Employees](https://www.dq5rocks.com/images/get_all_employees.jpg?raw=true "Title")  
  
  
Try to get one employee with id 3  
![Get one Employee](https://www.dq5rocks.com/images/get_employee_id_3.jpg?raw=true "Title")  
  
  
Try to search name '鳴人'  
![Search by name](https://www.dq5rocks.com/images/search_by_name.jpg?raw=true "Title")  
  
  
Try to update employee whose id is 2
![Search by name](https://www.dq5rocks.com/images/update_employee_id_2.jpg?raw=true "Title")  
  
  
Try to delete employee whose id is 4
![delete employee 4](https://www.dq5rocks.com/images/delete_employee_id_4.jpg?raw=true "Title")  
  
  
  
this above link probobaly may become unavailable in someday future,   
if i could not pay for domain name or vps payment  

上面的連結可能在未來有天會失效，如果我繳不出域名或VPS主機的錢  


## Contributing  
可愛的Me  

## Donate me

可以捐錢給我喔，i need your support  

- [國泰世華銀行收款帳號](#CathayBank) **銀行代碼 013 帳號 001-50-235346-9 戶名 KUN AN HSU 館前分行**  

- [Alipay(支付寶)](#alipay) **annbigbig@gmail.com**  

- [BitCoin](#Bitcoin)  ![BitcoinIcon](images/Bitcoin.png?raw=true "Thank you")

  **1FGEtWkZpo3WHzQqDw6aJvsaDyxNmX4H9**

- [Ethereum](#Ethereum)  ![EthereeumIcon](images/Ethereum.png?raw=true "Thank you")  
  **0x36077A217819cf747F938EbFad26Ec50e44cDC48**

## Contact me

- **annbigbig@gmail.com**   
2020年7月，又開始寫扣，祝我好運

## License

None. 無

