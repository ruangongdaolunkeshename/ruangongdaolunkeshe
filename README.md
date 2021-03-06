能力规范文稿管理系统
 
版本号	1.1.6
更新时间	2018.7.12
小组成员	陈子昂，彭磊，岳天一，赵啸宇，许奕璋
提交人	许奕璋
提交日期	2018.7.12
前期版本	
当前版本	1.1.6

1引言
1.1编写目的
本需求分析说明书对本项目第一阶段的內容进行分析，对需求细节和实现方式进行了较为详细的阐述。本需求说明书供业务和科技部门人员、软件需求提供人员、软件的概要设计人员、软件的开发人员、软件的测试人员使用，并作为产品验收确认的依据

1.2预期使用者
用户
管理者
开发人员
测试人员

1.3产品范围
利用JAVA，JSP语言建立平台界面，完成相关操作按钮、下拉框、指令等所有对应操作。


2综合描述
2.1用户类和特征
主要用户是浏览该网页的所有用户。用户没有专业的计算机知识，所以需要一个友好简单的界面。用户通过浏览该网页，可以对一些提案或文档进行审核。
尽可能的让用户不经过任何培训就能够较为熟练的应用此系统。
本系统的预期使用时间：7*24小时

2.2软硬件环境需求
操作系统：Windows
数据库：SQL
开发工具：IntelliJ IDEA

2.3假设和约束依赖
各个模块之间稳定协作
系统主要会分为几个模块，各个模块之间的稳定协作需要得到保证，保证系统7*24小时的稳定运行，尽量只保持周期性的维护。
系统安全
系统的安全是当前网络环境下的一个重要要求，使软件在受到恶意攻击的情形下依然能够继续正确运行及确保软件被在授权范围内合法使用系统的安全，软件的安全不仅关系着自身的盈利等，还关系着用户的各种信息。


3外部接口需求
3.1用户界面
要求尽量简洁的界面，争取直观的传递给各用户尽量多的讯息。
能够让未受过良好计算机教育的使用者可以较为轻松的使用该系统。

3.2通讯接口
遵循各种网络协议，满足各种浏览器的需求。


4系统功能需求
4.1用例模型

4.2说明和优先级
进入本系统之前，需要有登录和注册两个功能。操作根据用户名和密码进行登录，非会员点击注册按钮填写入会申请，等待管理者审核。
进入之后，本系统有前后两个模块，根据最终用户具有的不同功能将用户分为两类：
①用户（写作人员）：提案查询、提案编制、规范查询、规范编制、信息维护
②管理员：维持系统的正常，管理审核信息，以及所有写作人员的功能
前后模块的主要功能是信息发布
后台数据管理功能主要用于完成远程数据库服务器维护功能，包括接收数据的分类与信息的添加、删除、修改等功能，以及对网站操作员的管理等。此外网站所有动态信息维护也均由网站后台管理系统完成。
优先级：管理员 > 用户
所有操作均以username为唯一识别标志，用于后台判断。

4.3功能需求
进入系统之前：
①注册：
注册人拥有9个属性（其中包含一个隐藏的属性，即用于判断注册人的状态及身份，0表示注册人还未通过管理员的审核，1表示注册人通过了管理员的审核且其身份为写手用户，2表示注册人通过了管理员的审核且其身份为专委会管理员用户），其中姓名、性别（提供两个选项供用户选择）、出生日期（以年、月、日的顺序输入）、联系方式（11位数字，可用string）、所属行业分会和所属专委会是必填信息，不可为空，必须要填写完整才可以允许进行注册的申请操作。
而地址和推荐人部分不是必填项。但如果具有推荐人，将能够提高注册申请的成功性。
注册人点击提交以后，跳转到另一个界面。系统首先判断其6个必填项是否为null，如果为null，则注册失败，并提示注册者；如果不是null且6个必填项皆按标准格式输入，则申请成功，等待管理员的审核。
当注册人没有按照规定要求输入信息时，系统能够提示注册人哪里输入有误。
用例名称：	用户注册
用例说明：	未注册用户注册成为会员
参与者：	未注册用户
前置条件：	该用户不能使已经注册的账号（账号不能已经存在）
后置条件：	后台系统正确的收集用户提交的信息并保存到数据库表中
基本路径：	①Actor点击注册
②系统显示注册页面
③Actor填写用户名、密码等相关信息，点击提交
④后台系统处理该请求并最后显示注册成功
⑤注册成功后将跳转到页面进行登录
扩展路径：	Actor填写的信息格式不正确
系统提示输入正确的数据
注册失败
    系统再跳转到注册页面，提示Actor重新注册
补充说明：	暂无

②登录：
如果是已经完成注册申请并通过管理人员验证的用户，将可以通过首页登录区域直接进行登录操作。
首先，用户输入用户名和密码，并点击登录。系统会先判断用户输入的用户名和密码是否为null，如果为null，则提示用户；如果不为null，则调用数据库，来判断该用户输入的用户名所对应的密码是否正确，正确则判断用户身份并进入所对应的系统，错误则提示用户错误。
用例名称：	用户登录
用例说明：	用户登录进该系统
参与者：	已注册成功的用户
前置条件：	该用户输入的账号已经存在
后置条件：	后台系统调用数据库判断该用户输入的用户名是否匹配
基本路径：	①Actor输入用户名、密码
②点击登录
③系统调用数据库，返回信息
④判断用户的身份
⑤判断该用户输入的用户名、密码是否正确
⑥正确后跳转到功能界面
扩展路径：	Actor填写的用户名或密码不正确
系统提示输入正确的数据
登录失败
    系统再跳转到登录页面，提示Actor重新输入信息
补充说明：	暂无

进入系统之后：
如果是写手用户则进入写手功能界面，如果是管理员用户（三种管理员统称为管理员）则进入管理员功能界面。
①写手用户功能：提案查询、提案编制、规范查询、规范编制、信息维护、会员推荐
（1）提案查询
写者可通过提案的编号、名称和作者姓名这三类关键字进行范围锁定，系统自动按提案编号降序排列。系统以列表的形式进行展示。列表的内容（从左到右）包括编号、提案名称、作者、截止日期、状态、附议数、反对数、全选。写者点击提案名称可链接到此条提案详情（进入该提案的页面），该提案的页面包括提案ID、提案名称、提案作者、截止日期、提案内容、评论区，写者可在评论区空白框中进行评论，选择“附议”或“反对”键进行表态（必选项），最后提交。评论区内容包括评论人、评论内容和时间。查询结束后可返回到主界面。
注：只有已登录用户才能够进行查询。
用例名称：	提案查询
用例说明：	用户查询想要的提案
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到提案查询页面
基本路径：	①用户点击提案查询
②跳转到提案查询页面
③显示提案ID、名称、作者、截止日期、提案内容、评论区
扩展路径：	
补充说明：	暂无

（2）提案编制
写者填写相关提案的名称和提案内容，可进行打印、保存、提交。页面下方展示提案列表，写者可以看到自己提交的所有提案ID、名称、提交时间和对应的状态（同一建议人处于意见征集期的提案不能超过3项），但可以选择撤销在意见征集期的提案（撤销就不算在那3条之内）。//列表可含有全选功能。
注：仅写者有此权限。
用例名称：	提案编制
用例说明：	用户对相关提案进行编制
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到提案编制页面
基本路径：	①用户点击提案编制
②跳转到提案编制页面
③用户点击所需编译功能
扩展路径：	
补充说明：	暂无

（3）规范查询
类似于提案查询。写者可通过规范的编号、名称和作者姓名这三类关键字进行范围锁定，系统自动按规范编号降序排列。系统以列表的形式进行展示。列表的内容（从左到右）包括编号、规范名称、作者、截止日期、状态、附议数、反对数、全选。写者点击规范名称可链接到此条规范详情（进入该规范的页面），该规范的页面包括规范ID、规范名称、规范作者、截止日期、规范内容、评论区，写者可在评论区空白框中进行评论，选择“附议”或“反对”键进行表态（必选项），最后提交。评论区内容包括评论人、评论内容和时间。查询结束后可返回到主界面。
注：只有已登录用户才能够进行查询。
用例名称：	规范查询
用例说明：	用户对相关规范进行查询
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到规范查询页面
基本路径：	①用户点击规范查询
②跳转到规范查询页面
③查看相关规范
扩展路径：	
补充说明：	暂无

（4）规范编制
类似于提案编制。写者填写相关规范的名称和规范内容，可进行打印、保存、提交。页面下方展示规范列表，写者可以看到自己提交的所有规范ID、名称、提交时间和对应的状态（同一建议人处于意见征集期的提案不能超过3项），但可以选择撤销在意见征集期的提案（撤销就不算在那3条之内）。//列表可含有全选功能。
用例名称：	规范编制
用例说明：	用户对相关规范进行编制
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到规范编制页面
基本路径：	①用户点击规范编制
②跳转到规范编制页面
扩展路径：	
补充说明：	暂无

（5）信息维护
用户（写手和管理员）对自己的显性个人信息（除flat属性）进行修改
用例名称：	信息维护
用例说明：	写手用户对自己的个人信息进行修改
管理员用户对写手用户信息进行删改
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到信息维护页面
基本路径：	①用户点击信息维护
②跳转到信息维护页面
③用户对已有信息进行修改
④将修改的信息提交到数据库
扩展路径：	
补充说明：	暂无

（6）会员推荐
写手担当注册用户的推荐人，向系统推荐该用户。有会员推荐的注册者可增大其注册审核通过的概率。
用例名称：	会员推荐
用例说明：	写手用户充当注册用户的推荐人，向系统推荐该用户，使该用户的审核通过率增大
参与者：	已登录用户
前置条件：	该用户通过身份认证，已经登录进功能页面
后置条件：	跳转到会员推荐页面
基本路径：	①用户点击会员推荐
②跳转到会员推荐页面
③用户向系统推荐注册者
④确认推荐人信息，点击提交
扩展路径：	
补充说明：	暂无


②管理员用户功能：身份管理、提案审批、启动任务
（1）身份管理（即管理员对注册人提交的信息进行审核，点击通过或者未通过）
管理员登录系统——>系统提示管理员有新的申请信息——>管理员查看新信息——>系统展示信息，且有推荐人的信息会有明确标注——>管理员点击通过——>系统改变该用户的flat值，并把该用户信息转入会员信息表
当注册人申请的是管理员用户时，审核通过需选择让其成为专委会管理员、行业分会管理员或研究会管理员三种身份其一。
用例名称：	管理员身份管理
用例说明：	管理员对用户的注册信息进行审批
参与者：	已登录的管理员用户
前置条件：	该用户通过管理员身份认证，已经登录进功能页面
后置条件：	跳转到信息维护页面
基本路径：	①管理员选择审批功能
②系统调用数据库中已注册但未审批的人员信息
③将这些信息已列表的形式展示出来
④管理员进行查看
⑤管理员根据注册者的提交信息选择审核通过和审核未通过
⑥将管理员审核通过的用户列入会员用户的数据库中
⑦将管理员已经审核过的注册者信息从已注册但未审批人员的数据库中删除
扩展路径：	
补充说明：	暂无

注：其中第三步通过点击查看申请人的具体信息将进入下一页面，此页面分为上下两部分：①入会申请表（即注册人的信息）；②会员推荐表（即推荐人的信息）

（2）提案审批
该页面中有推荐、备案、立案三个选项，“推荐”选项根据该管理员注册时填写的专委会名称按类别进入（也就是说每名管理员只能看到关于自己注册时填写的专委会方面的信息，其他专委会方面信息的看不到）（比如说提案分为金融类和IT类，如果该管理员注册时填写的专委会为金融类，则他在推荐这个选项中就只能看到有关金融类的提案，看不到有关IT类的提案）（可以在写手写提案的时候多加一个分类选项，以便将写手写的提案保存到所属不同的专委会信息中）
“备案”选项同理，它是根据该管理员注册时填写的行业分会的名称按类别进入。
“立案”选项只能是“研究会”身份的管理者才可以进入。
注：顺序应该是先写推荐信息，完成意见征询，再备案，备案通过之后才能立案。

专委会人员通过点击推荐，进入推荐界面展示提案信息，可以单个或批量进行推荐。通过点击提案名称进入提案详情，查看提案信息，并完成意见征集，填写评论进行附议或反对。也可通过评论区阅读相关评论。

行业分会人员通过点击备案进入备案界面，展示相关提案列表。通过点击提案名称进入提案详情界面，填写提案备案表上报备案。

（3）启动任务
将通过研究会管理员立案的提案发布。
可以在立案操作通过之后自动进行启动任务的操作。
用例名称：	启动任务
用例说明：	管理员对已经立案通过的项目进行启动
参与者：	已登录的管理员用户
前置条件：	该任务已通过研究会管理员立案通过
后置条件：	跳转到启动任务页面
基本路径：	①管理员选择任务启动
②系统调用数据库中改提案信息
③判断是否通过了研究会管理员的立案通过
④将数据返回
⑤管理员根据数据判断是否进行启动任务
⑥管理员进行启动任务操作
扩展路径：	
补充说明：	暂无


注销操作：
写手用户和管理员用户在进行完相应操作之后，都可按注销选项，退出当前登录。如果以后还想登录，需再次输入用户名和密码。
用户按完注销操作以后，跳转到首页面（即输入用户名和密码的那个页面，且用户名和密码栏都为空）
用例名称：	注销
用例说明：	已登录进系统的用户退出登录
参与者：	写手、管理员
前置条件：	该用户已登录进该系统
后置条件：	跳转到登录页面
基本路径：	①用户选择注销操作
②系统取消该用户此次对该系统的访问权限
③跳转到登录页面
扩展路径：	
补充说明：	暂无


5其他非功能需求
5.1性能需求
时间特性：页面刷新时间不能超过3秒，页面直接的跳转不超过4秒。满足用户需求快速得到信息的要求，页面的优化要做好，使得每个用户能感觉到到能够流畅迅速的查找到自己所需要的信息。
5.2技术选型需求
①根据业务需求选用SQL数据库
②使用Java Web技术体系，前段技术选型HTML
③开发工具选用IntelliJ IDEA，是一个Java语言开发的集成环境
③版本控制工具选用GitHub，管理项目任务分配和进度安排

5.3软件质量属性
易用性由于易学性，或者可移植性由于有效性。

5.4用户文档
暂无编写需求







