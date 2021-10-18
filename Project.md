<div dir='rtl' align="justify">
  

## تعریف پروژه


فرض کنید ماتریس خلوت داده شده را M بنامیم. برای تشکیل داده ساختاری که از حافظه به شکلی بهینه بهره ببرد، باید ساختاری اتخاذ شود که تنها خانه‌های غیرصفر را در خود ذخیره کند. به همین دلیل نمایش بهینه‌ی ماتریس خلوت به شکل زیر معرفی می‌شود:

آرایه‌ای ازلیست‌های پیوندی، به‌طوری که به ازای هر ردیف یا ستون از ماتریس، لیستی ازعناصر غیر صفرآن نگه‌داری و در نهایت درآرایه‌ای با اندازه‌ی معین (تعداد سطرها یا ستون‌ها)، ذخیره می‌شوند.

داده ساختار پیشنهادی برای پیاده‌سازی، شامل دو ساختار است: node و matrix


هر گره برای عناصر غیر صفر از سه بخش اندیس سطر یا ستون، مقدار، اشاره‌گری به عنصر غیر صفر بعدی در همان سطر و یا اشاره‌گری به عنصر غیر صفر بعدی در آن ستون، تشکیل شده‌ است که برای شکل دادن لیست ‍‍پیوندی از آنها استفاده می‌شود.

جزء ماتریسی داده ساختار، یک ساختار است شامل آرایه‌ای ازاشاره‌گرها که هر کدام به اولین عنصرغیر صفر در یک ردیف یا ستون اشاره می کنند.

چنانچه این آرایه روی سطرها تعریف شده باشد، اندیس ستون و اگر آرایه روی ستون ها تعریف شده باشد، اندیس سطر در گره نگهداری می‌شود. در اینجا، ما از آرایه‌ای از گره‌های به هم مرتبط برای ساختن ساختاری استفاده می‌کنیم که امکان پیمایش آن از هراندیس دلخواه از ردیف‌ها و یا ستون‌ها، وجود دارد.



شکل زیر به شما در درک و پیاده‌سازی ساختار توصیف شده کمک خواهد کرد:


 ![تصویر ساختار آرایه و لیست‌های پیوندی](https://s20.picofile.com/file/8442321984/Untitled_presentation.png) 



(دقت کنید در این مرحله شما باید یکی از دو آرایة نشان داده شده را پیاده‌سازی کنید.) 


### بخش امتیازی
شما می‌توانید با پیاده‌سازی هر دو آرایه، امتیاز بیشتری کسب کنید. در این نوع پیاده سازی ساختار هر گره برای عناصر غیر صفر از چهار بخش زوج مرتب اندیس سطر و ستون، مقدار، اشاره‌گری به عنصر غیر صفر بعدی در همان سطر و اشاره‌گری به عنصر غیر صفر بعدی در آن ستون، تشکیل شده‌ است که برای شکل دادن لیست ‍‍پیوندی از آنها استفاده می‌شود.
همچنین جزء ماتریسی داده ساختار، به ساختاری متشکل از دو آرایه ازاشاره‌گرها برای نگه داری عنصر ابتدایی هر لیست پیوندی، تغییر می‌یابد:


 ![تصویر ساختار آرایه و لیست‌های پیوندی](https://s21.picofile.com/file/8442324918/Untitled_presentation_1_.png) 

## رویدادها

برای هر ماتریس مجموعه‌ای از اتفاقات (eventها) امکان‌پذیر است. 
رویدادها با عدد ٠ شروع می‌شوند. 
  این رویدادها از دسته های زیر می‌باشند:


### درج گره (کد ٠)

در اثر این رویداد، یک گره جدید به لیست پیوندی اضافه می‌شود. اضافه شدن یک گره به لیست معادل تغییر مقدار یک درایه از ماتریس از مقدار صفر به مقدار خواسته شده است. این تابع باید با دریافت سطر، ستون و مقدار مورد نظر به عنوان ورودی، گره‌ی جدیدی ساخته و با درج آن در محل مناسب ماتریس را بروز کند.


<div dir='ltr' align="justify">

```void insert(int row, int col, int value)```

</div>


### حذف گره (کد ۱)

در اثر این رویداد، یک گره از لیست پیوندی حذف می‌شود که معادل تغییر مقدار یکی از درایه‌های غیر صفر ماتریس به صفر است. این تابع نیز با دریافت سطر و ستون مورد نظر به عنوان ورودی، گره‌ی موجود را حذف و پیوندها را بروزرسانی می‌کند.


<div dir='ltr' align="justify">

```void delete(int row, int col)```

</div>

### جست و جو (کد ۲)

در اثر این رویداد، وجود یا عدم وجود یک گره در لیست پیوندی (معادل جست و جوی یک مقدار در ماتریس) تشخیص داده می‌شود. این تابع با دریافت مقدار مورد نظر، پیغام مناسب را در هر سناریو به کاربر نمایش می‌دهد.


<div dir='ltr' align="justify">

```void search(int value)```

</div>

### بروزرسانی (کد ۳)

در اثر این رویداد، مقدار یک گره موجود بروزرسانی می‌شود. این تابع باید با دریافت اندیس سطر و ستون مورد نظر و مقدار جدید برای بروزرسانی، عملیات خواسته شده را انجام دهد.


<div dir='ltr' align="justify">

```void update(int row, int col, int value)```

</div>


### چاپ (کد ۴)

در اثر این رویداد، ماتریس داده شده با فرمت خواسته شده چاپ و نمایش داده می‌شود.


<div dir='ltr' align="justify">

```void print(boolean type)```

</div>


#### نمایش ماتریس به صورت آرایه دو بعدی (کد ٠)

در این نوع نمایش ماتریس، شما می‌بایستی داده ساختار پیاده‌سازی شده را به فرم اولیه آن و به صورت آرایه دو بعدی تبدیل و نمایش دهید.

#### نمایش ماتریس به صورت فشرده شده (کد ۱)

در این نوع نمایش، داده‌های غیرضروری و ناخواسته (عناصر صفر) چاپ نخواهند شد و قالب پیشنهادی زیر برای نمایش داده‌ها مورد استفاده قرار می‌گیرد:

</div>
<div dir='ltr' align="justify">
  
##### Format:
  
`[row] [col] [value]`

##### Example:

```
1 1 96
1 2 10
2 1 18
2 2 33
```

</div>
<div dir='rtl' align="justify">

### ذخیره سازی (کد ۵)

در اثر این رویداد، داده‌ها در فایل ذخیره می‌شوند.


<div dir='ltr' align="justify">

```void save_file( )```

</div>

## ورودی و خروجی

### ورودی

برنامه شما باید با دریافت مجموعه‌ای از داده‌ها در قالب سی اس وی (csv) بتواند اطلاعات را خوانده و سپس آن‌ها را به صورت آرایه‌ای از لیست‌های پیوندی، ذخیره کند.
فایل های سی اس وی نمونه در هیمن ریپو موجود است میتوانید برای تست از آن ها استفاده نمایید. ابتدا دو فایل اول که حجم های کمتر دارند تست کنید سپس به سراغ فایل سوم بروید.
دقت کنید فایل M(7000,9000) به دلیل حجم زیاد زیپ شده پس از کلون از پروژه آن را آنزیپ کنید و در مرحله آخر سعی کنید آن را نیز با پروژه خود به فرمت فشرده درآورید.
### خروجی

پس از اجرای صحیح مجموعه‌ای از رویدادها که پیش‌تر شرح داده شد، برنامه باید قادر به چاپ اطلاعات تحت دو نمایش معرفی شده و همچنین ذخیره‌سازی فایل داده‌ها در قالب سی اس وی (csv) باشد.

## نکات تکمیلی

- از کدهای معرفی شده جهت ساخت منو برای سادگی انتخاب عملیات مورد نظر استفاده کنید.
- برنامه شما باید امکان خواندن داده‌های جدید را از فایل‌های دیگر نیز داشته باشد. زیرا داده‌های آزمایشی که در اختیار شما قرار خواهند گرفت با داده‌هایی که در هنگام تحویل پروژه به شما داده خواهد شد متفاوت است.
- در صورت پیاده‌سازی هر دو آرایه (بخش امتیازی)، به تغییرات ضروری در تعریف رویدادهای ذکر شده، توجه کنید.
- پس از پیاده‌سازی مقدمات اولیه کد (کلاس بندی و خواندن از فایل)، قبل از شروع پیاده‌سازی رویدادها،  پروژه را کامیت کنید.
- سپس پس از پیاده‌سازی هر رویداد، تست و اطمینان کامل از نحوه صحیح عملکرد آن، آن را با پیغام مناسب کامیت کنید.
-  پس از پیاده‌سازی کامل پروژه آن را در برنچ جدید  project پوش کنید.


## موارد نمره دهی
- پیاده‌سازی درست رویدادها
- کامیت و پوش طبق دستورالعمل گفته شده
- تمیزی کد شامل کلاس بندی درست، نام گذاری صحیح متدها و متغیرها، داشتن متد مین کوتاه و استفاده از توابع بصورت صحیح
- نمایش گرافیکی داده ساختار فشرده شده و کل پروژه نمره اضافه خیلی کمی دارد؛ برای همین تمرکز خود را بیشتر بر روی پیاده‌سازی صحیح ، کامل و طبق اصول کلین کد،  قرار دهید.
</div>
<div dir='ltr' align="justify">

موفق و پیروز باشید

</div>