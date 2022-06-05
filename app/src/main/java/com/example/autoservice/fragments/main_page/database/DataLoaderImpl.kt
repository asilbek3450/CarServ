package com.example.autoservice.fragments.main_page.database

import com.example.autoservice.fragments.main_page.models.autoservice.AutoService
import com.example.autoservice.fragments.main_page.models.autoservice.AutoServiceJob
import com.example.autoservice.fragments.main_page.models.car_wash.CarWash
import com.example.autoservice.fragments.main_page.models.car_wash.CarWashJob
import com.example.autoservice.fragments.main_page.models.petrol.PetrolFilial

class DataLoaderImpl : DataLoader {
    private lateinit var serviceList: ArrayList<AutoService>
    private lateinit var carWashList: ArrayList<CarWash>
    private lateinit var petrolList: ArrayList<PetrolFilial>

    init {
        loadData()
    }

    private fun loadData() {
        loadAutoService()
        loadCarWash()
        loadPetrol()
    }

    private fun loadAutoService() {
        var id = 0
        serviceList = ArrayList()
        val jobList1 = ArrayList<AutoServiceJob>()
        jobList1.add(
            AutoServiceJob(
                "Avtomobil poliklari",
                25000,
                "Barcha avtomobil markalari uchun mavjud. Chiroyli, yuqori sifatli, avtomobilingiz polini to'liq qoplaydi"
            )
        )
        jobList1.add(
            AutoServiceJob(
                "Texplastinlar",
                100000,
                "Kauchuk texnik materiallarning eng keng tarqalgan turi - texnik plastinka. U avtomobil salonida gilam shaklida, turli sohalardagi korxonalarda amortizatorlar, muhrlar, elektr izolyatsion xom ashyo sifatida ishlatilishi mumkin. Texnik plastinka tarkibidagi asosiy komponent kauchuk hisoblanadi. Kerakli xususiyatlarga va maqsadga qarab, ba'zida lateks ishlatiladi."
            )
        )
        jobList1.add(
            AutoServiceJob(
                "Rezina asosida kavrolin",
                730000,
                "Asl Skoda Kodiaq rezina pol tagliklari, 4 qismli to'plam. Asl Skoda aksessuari bilan 100% mukammal mos keladi. Dizayn: old va orqa pol tagida Kodiaq yozuvi bilan, mahkamlash tizimi: tugma (dumaloq), material: yuqori sifatli TPE (termoplastik elastomer) plastmassa, oddiy polga nisbatan engilroq."
            )
        )
        jobList1.add(
            AutoServiceJob(
                "Himoya signal tasmalari",
                50000,
                "To'g'ri joyni to'sish, cheklash, himoya qilish va nazorat qilish uchun lentalari bo'lgan zamonaviy krom qoplangan tokchalar"
            )
        )
        serviceList.add(AutoService(id++, "RTI-LIDER-PROM ЧП", jobList1, 41.264534, 69.239878))

        val jobList2 = ArrayList<AutoServiceJob>()
        jobList2.add(
            AutoServiceJob(
                "Avto disklarni ta'mirlash",
                150000,
                "Quyma, yengil qotishma va po'latdan shtamplangan avto disklarni ta'mirlash. G'ildiraklarni dastgohlarni ta'mirlash bo'yicha eng yangi texnologiya."
            )
        )
        jobList2.add(
            AutoServiceJob(
                "Avtomobil qopqog'i",
                55000,
                "13 14 15 o'lchamli g'ildiraklar uchun zavod qopqoqlari a'lo 100% sifat. Yetkazib berish mavjud!"
            )
        )
        jobList2.add(
            AutoServiceJob(
                "Vulkanizatsiya",
                25000,
                "Barcha turdagi avtomobil balonlarini yamash, yangi qo'yish xizmati"
            )
        )
        serviceList.add(AutoService(id++, "DISK OSIYO", jobList2, 41.250351, 69.217247))

        val jobList3 = ArrayList<AutoServiceJob>()
        jobList3.add(
            AutoServiceJob(
                "Injektorlarni diagnostika qilish",
                200000,
                "Avtotransport vositalariga texnik xizmat ko'rsatish va ta'mirlash ishlarini tashkil etish va amalga oshirish."
            )
        )
        jobList3.add(
            AutoServiceJob(
                "AMOVT qarshi nasosi",
                350000,
                "Injektorlarni diagnostika qilish, texnik xizmat ko'rsatish va joriy ta'mirlash, AMOVT qarshi nasosi."
            )
        )
        jobList3.add(
            AutoServiceJob(
                "Karbyuratorni",
                120000,
                "Karbyuratorni  dvigatelning elektr ta'minoti tizimidagi nosozliklarni aniqlash va bartaraf etish. Karbyuratorni sozlash."
            )
        )
        jobList3.add(
            AutoServiceJob(
                "Tormoz tizimlari",
                80000,
                "Shlangi tormoz tizimlari va to'xtash tormozlarini diagnostika qilish, texnik xizmat ko'rsatish va muntazam ta'mirlash."
            )
        )
        serviceList.add(AutoService(id++, "AVTOTEXXIZMAT MCHJ", jobList3, 41.255983, 69.190407))

        val jobList4 = ArrayList<AutoServiceJob>()
        jobList4.add(
            AutoServiceJob(
                "Dvigatelni ta'mirlash",
                250000,
                "Dvigatellar va avtomat uzatmalarni kapital ta'mirlash. Chevrolet, Lexus, Toyota, Honda, Mazda, Mitsubishi, Mersedes, Porsche, Bmw, Audi, WV, Land Rover, Yaguar. Tesla. Elektr transport vositalari. Barcha ta'mirlash ishlari kafolatlangan."
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Xodovoy",
                300000,
                "Dvigatel va ishlaydigan mexanizmni sifatli ta'mirlash."
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Moy almashtirish",
                75000,
                "Dvigatel moyini almashtirish. Mobil 1, Aral, Adinol. Замена масла в Акпп и Мкпп."
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Kuzov",
                950000,
                "Korpusni himoya qilish uchun keramik kompozitsiyalarni qo'llashni professional sayqallash, ichki va dvigatelni plyonka bilan quruq tozalash."
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Shovqin izolatsiyasi (shumka)",
                1500000,
                "Shumka va eshik regirilofka . Hamamsi ishonchli, sifatli"
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Polirovka",
                1156500,
                "Kechasi ko'rishning cheklanganligi ishlov berishning yomonlashishiga olib keladi va baxtsiz hodisa xavfini oshiradi. Buni istisno qilish uchun sertifikatlangan xizmat ko'rsatish markazlarida avtomobil faralari ko'zoynaklarini professional polishingni amalga oshirish tavsiya etiladi."
            )
        )
        jobList4.add(
            AutoServiceJob(
                "Kompyuter diagnostika",
                450000,
                "Dvigatelning kompyuter diagnostikasi."
            )
        )
        serviceList.add(AutoService(id++, "AVTOTEH-MM MChJ", jobList4, 41.219154, 69.241264))

        val jobList5 = ArrayList<AutoServiceJob>()
        jobList5.add(
            AutoServiceJob(
                "Moy almashtirish",
                80000,
                "Dvigatel moyini almashtirish. Alinol, Aral, Adinol. Moy almashtirish Акпп va Мкпп."
            )
        )
        jobList5.add(
            AutoServiceJob(
                "Motor xodovoy",
                100000,
                "Biz barcha avtomobil markalarining motorlarini to'liq ta'mirlaymiz, noldan, shassini tiklaymiz va ta'mirlaymiz. Narxlar qat'iy, hech qanday o'zgartirishlarsiz."
            )
        )
        jobList5.add(
            AutoServiceJob(
                "Anti-radar yangilash",
                60000,
                "Eng so'ngi ma'lumotlar asosida yangilaymiz. Jarimalardan halos bo'lasiz"
            )
        )
        jobList5.add(
            AutoServiceJob(
                "Vulkanizatsiya",
                30000,
                "Barcha turdagi avtomobil balonlarini yamash, yangi qo'yish xizmati"
            )
        )
        serviceList.add(
            AutoService(
                id++,
                "HUMO-A-SERVIS AVTOSERVIS",
                jobList5,
                41.378196,
                69.269695
            )
        )

        val jobList6 = ArrayList<AutoServiceJob>()
        jobList6.add(
            AutoServiceJob(
                "Avtomobil poliklari",
                25000,
                "Barcha avtomobil markalari uchun mavjud. Chiroyli, yuqori sifatli, avtomobilingiz polini to'liq qoplaydi"
            )
        )
        jobList6.add(
            AutoServiceJob(
                "Texplastinlar",
                100000,
                "Kauchuk texnik materiallarning eng keng tarqalgan turi - texnik plastinka. U avtomobil salonida gilam shaklida, turli sohalardagi korxonalarda amortizatorlar, muhrlar, elektr izolyatsion xom ashyo sifatida ishlatilishi mumkin. Texnik plastinka tarkibidagi asosiy komponent kauchuk hisoblanadi. Kerakli xususiyatlarga va maqsadga qarab, ba'zida lateks ishlatiladi."
            )
        )
        jobList6.add(
            AutoServiceJob(
                "Rezina asosida kavrolin",
                730000,
                "Asl Skoda Kodiaq rezina pol tagliklari, 4 qismli to'plam. Asl Skoda aksessuari bilan 100% mukammal mos keladi. Dizayn: old va orqa pol tagida Kodiaq yozuvi bilan, mahkamlash tizimi: tugma (dumaloq), material: yuqori sifatli TPE (termoplastik elastomer) plastmassa, oddiy polga nisbatan engilroq."
            )
        )
        jobList6.add(
            AutoServiceJob(
                "Himoya signal tasmalari",
                50000,
                "To'g'ri joyni to'sish, cheklash, himoya qilish va nazorat qilish uchun lentalari bo'lgan zamonaviy krom qoplangan tokchalar"
            )
        )
        serviceList.add(
            AutoService(
                id++,
                "\"TOSHVILOYATAVTOTEXXIZMAT\" MChJ",
                jobList6,
                41.264534,
                69.239878
            )
        )

        val jobList7 = ArrayList<AutoServiceJob>()
        jobList7.add(
            AutoServiceJob(
                "Avto disklarni ta'mirlash",
                150000,
                "Quyma, yengil qotishma va po'latdan shtamplangan avto disklarni ta'mirlash. G'ildiraklarni dastgohlarni ta'mirlash bo'yicha eng yangi texnologiya."
            )
        )
        jobList7.add(
            AutoServiceJob(
                "Avtomobil qopqog'i",
                55000,
                "13 14 15 o'lchamli g'ildiraklar uchun zavod qopqoqlari a'lo 100% sifat. Yetkazib berish mavjud!"
            )
        )
        jobList7.add(
            AutoServiceJob(
                "Vulkanizatsiya",
                25000,
                "Barcha turdagi avtomobil balonlarini yamash, yangi qo'yish xizmati"
            )
        )
        serviceList.add(
            AutoService(
                id++,
                "AVTOritet  (Lunacharskiy)",
                jobList7,
                41.34103265,
                69.3588150
            )
        )

        val jobList8 = ArrayList<AutoServiceJob>()
        jobList8.add(
            AutoServiceJob(
                "Injektorlarni diagnostika qilish",
                200000,
                "Avtotransport vositalariga texnik xizmat ko'rsatish va ta'mirlash ishlarini tashkil etish va amalga oshirish."
            )
        )
        jobList8.add(
            AutoServiceJob(
                "AMOVT qarshi nasosi",
                350000,
                "Injektorlarni diagnostika qilish, texnik xizmat ko'rsatish va joriy ta'mirlash, AMOVT qarshi nasosi."
            )
        )
        jobList8.add(
            AutoServiceJob(
                "Karbyuratorni",
                120000,
                "Karbyuratorni  dvigatelning elektr ta'minoti tizimidagi nosozliklarni aniqlash va bartaraf etish. Karbyuratorni sozlash."
            )
        )
        jobList8.add(
            AutoServiceJob(
                "Tormoz tizimlari",
                80000,
                "Shlangi tormoz tizimlari va to'xtash tormozlarini diagnostika qilish, texnik xizmat ko'rsatish va muntazam ta'mirlash."
            )
        )
        serviceList.add(AutoService(id++, "AVTOritet Kadisheva", jobList8, 41.28386106, 69.3406991))

        val jobList9 = ArrayList<AutoServiceJob>()
        jobList9.add(
            AutoServiceJob(
                "Dvigatelni ta'mirlash",
                250000,
                "Dvigatellar va avtomat uzatmalarni kapital ta'mirlash. Chevrolet, Lexus, Toyota, Honda, Mazda, Mitsubishi, Mersedes, Porsche, Bmw, Audi, WV, Land Rover, Yaguar. Tesla. Elektr transport vositalari. Barcha ta'mirlash ishlari kafolatlangan."
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Xodovoy",
                300000,
                "Dvigatel va ishlaydigan mexanizmni sifatli ta'mirlash."
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Moy almashtirish",
                75000,
                "Dvigatel moyini almashtirish. Mobil 1, Aral, Adinol. Замена масла в Акпп и Мкпп."
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Kuzov",
                950000,
                "Korpusni himoya qilish uchun keramik kompozitsiyalarni qo'llashni professional sayqallash, ichki va dvigatelni plyonka bilan quruq tozalash."
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Shovqin izolatsiyasi (shumka)",
                1500000,
                "Shumka va eshik regirilofka . Hamamsi ishonchli, sifatli"
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Polirovka",
                1156500,
                "Kechasi ko'rishning cheklanganligi ishlov berishning yomonlashishiga olib keladi va baxtsiz hodisa xavfini oshiradi. Buni istisno qilish uchun sertifikatlangan xizmat ko'rsatish markazlarida avtomobil faralari ko'zoynaklarini professional polishingni amalga oshirish tavsiya etiladi."
            )
        )
        jobList9.add(
            AutoServiceJob(
                "Kompyuter diagnostika",
                450000,
                "Dvigatelning kompyuter diagnostikasi."
            )
        )
        serviceList.add(AutoService(id++, "AVTOritet Severniy", jobList9, 41.2954358, 69.2922231))

        val jobList10 = ArrayList<AutoServiceJob>()
        jobList10.add(
            AutoServiceJob(
                "Moy almashtirish",
                80000,
                "Dvigatel moyini almashtirish. Alinol, Aral, Adinol. Moy almashtirish Акпп va Мкпп."
            )
        )
        jobList10.add(
            AutoServiceJob(
                "Motor xodovoy",
                100000,
                "Biz barcha avtomobil markalarining motorlarini to'liq ta'mirlaymiz, noldan, shassini tiklaymiz va ta'mirlaymiz. Narxlar qat'iy, hech qanday o'zgartirishlarsiz."
            )
        )
        jobList10.add(
            AutoServiceJob(
                "Anti-radar yangilash",
                60000,
                "Eng so'ngi ma'lumotlar asosida yangilaymiz. Jarimalardan halos bo'lasiz"
            )
        )
        jobList10.add(
            AutoServiceJob(
                "Vulkanizatsiya",
                30000,
                "Barcha turdagi avtomobil balonlarini yamash, yangi qo'yish xizmati"
            )
        )
        serviceList.add(AutoService(id, "LUX TUNING UZ", jobList10, 41.34315623, 69.2112270))
    }

    private fun loadCarWash() {
        var id = 0
        carWashList = ArrayList()
        val washList1 = ArrayList<CarWashJob>()
        washList1.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak,  matorni yuvish, ustki qismlar va o'rindiqlarni tozalash",
                120000
            )
        )
        washList1.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish, pena sepish",
                70000
            )
        )
        washList1.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                50000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "AVTOritet",
                washList1,
                41.312341,
                69.208998
            )
        )

        val washList2 = ArrayList<CarWashJob>()
        washList2.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish, matorni yuvish",
                90000
            )
        )
        washList2.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish , pena sepish",
                60000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "ATLANT-F",
                washList2,
                41.008091,
                71.655789
            )
        )

        val washList3 = ArrayList<CarWashJob>()
        washList3.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak, yuqori darajada quritish, ustki qismlar va o'rindiqlarni tozalash",
                120000
            )
        )
        washList3.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish, pena sepish",
                80000
            )
        )
        washList3.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                60000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "BLACK STAR CAR WASH",
                washList3,
                41.353168,
                70.645262
            )
        )

        val washList4 = ArrayList<CarWashJob>()
        washList4.add(
            CarWashJob(
                "yuqori",
                "deluxe + ikki marta ko'pikli lak, yuqori darajada quritish",
                100000
            )
        )
        washList4.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish",
                70000
            )
        )
        washList4.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                50000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "AVTOMOYKA",
                washList4,
                41.3463772,
                69.2669548
            )
        )

        val washList5 = ArrayList<CarWashJob>()
        washList5.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish, quritish, motorni yuvish",
                80000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "SADIKOV avtomoyka",
                washList5,
                41.126463,
                69.735539
            )
        )

        val washList6 = ArrayList<CarWashJob>()
        washList6.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak, yuqori darajada quritish, ustki qismlar va o'rindiqlarni tozalash",
                130000
            )
        )
        washList6.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish, pena sepish",
                90000
            )
        )
        washList6.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                70000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "MaPPo avtomoyka",
                washList6,
                41.3463772,
                69.2669548
            )
        )

        val washList7 = ArrayList<CarWashJob>()
        washList7.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish va quritish",
                70000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "HUMO AVTO MOYKA",
                washList7,
                41.287625,
                69.2281414
            )
        )

        val washList8 = ArrayList<CarWashJob>()
        washList8.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak, yuqori darajada quritish",
                100000
            )
        )
        washList8.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish",
                70000
            )
        )
        washList8.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                50000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "AFEX",
                washList8,
                39.552278,
                69.847346
            )
        )

        val washList9 = ArrayList<CarWashJob>()
        washList9.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak, yuqori darajada quritish",
                130000
            )
        )
        washList9.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish",
                90000
            )
        )
        carWashList.add(
            CarWash(
                id++,
                "Avtomoyka",
                washList9,
                41.3180418,
                69.2717561
            )
        )

        val washList10 = ArrayList<CarWashJob>()
        washList10.add(
            CarWashJob(
                "yuqori",
                "deluxe + uch marta ko'pikli lak, ustki qismlar va o'rindiqlarni tozalash, motorni yuvish",
                150000
            )
        )
        washList10.add(
            CarWashJob(
                "lyuks",
                "basic + g'ildiraklarni tozalash va qoraytirish",
                90000
            )
        )
        washList10.add(
            CarWashJob(
                "oddiy",
                "mashinani tashqi va ichki tomonini yuvish",
                60000
            )
        )
        carWashList.add(
            CarWash(
                id,
                "M5 BUNKER",
                washList10,
                41.3383594,
                69.330409
            )
        )
    }

    private fun loadPetrol() {
        var id = 0
        petrolList = ArrayList()
        petrolList.add(
            PetrolFilial(
                id++,
                "Uzbekneftgaz",
                10000,
                9100,
                8900,
                6800,
                11000,
                2800,
                41.31468364,
                69.327920
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Uzbekneftgaz",
                10000,
                9100,
                8900,
                6800,
                11000,
                2800,
                41.30764526,
                69.28400960
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Uzbekneftgaz",
                10000,
                9100,
                8900,
                6800,
                11000,
                2800,
                41.34575294,
                69.26043448
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Uzbekneftgaz",
                10000,
                9100,
                8900,
                6800,
                11000,
                2800,
                41.33161493,
                69.195685236
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Uzbekneftgaz",
                10000,
                9100,
                8900,
                6800,
                11000,
                2800,
                41.28967892,
                69.1692569739
            )
        )


        petrolList.add(
            PetrolFilial(
                id++,
                "Mustang",
                10200,
                9600,
                0,
                6900,
                0,
                2700,
                41.269996376,
                69.2894112
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Mustang",
                10200,
                9600,
                0,
                6900,
                0,
                2700,
                41.312430927,
                69.34468620
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Mustang",
                10200,
                9600,
                0,
                6900,
                0,
                2700,
                41.355479889,
                69.2678875576
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Mustang",
                10200,
                9600,
                0,
                6900,
                0,
                2700,
                41.3457986,
                69.2074606
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Mustang",
                10200,
                9600,
                0,
                6900,
                0,
                2700,
                41.26858185,
                69.21084521
            )
        )



        petrolList.add(
            PetrolFilial(
                id++,
                "Poytaxt oil",
                10200,
                9300,
                9100,
                6900,
                0,
                0,
                41.3499352,
                69.314609134
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Poytaxt oil",
                10200,
                9300,
                9100,
                6900,
                0,
                0,
                41.297079,
                69.291434
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Poytaxt oil",
                10200,
                9300,
                9100,
                6900,
                0,
                0,
                41.2615942,
                69.22834980
            )
        )


        petrolList.add(
            PetrolFilial(
                id++,
                "Lukoil",
                11290,
                10490,
                0,
                6990,
                11790,
                2700,
                41.3106513,
                69.3463164
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Lukoil",
                11290,
                10490,
                0,
                6990,
                11790,
                2700,
                41.313522096,
                69.25269875
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "Lukoil",
                11290,
                10490,
                0,
                6990,
                11790,
                2700,
                41.2431973,
                69.2271730
            )
        )


        petrolList.add(
            PetrolFilial(
                id++,
                "IBR petroleum station",
                9200,
                8900,
                0,
                6900,
                10200,
                0,
                41.30377170,
                69.1934647
            )
        )
        petrolList.add(
            PetrolFilial(
                id++,
                "IBR petroleum station",
                9200,
                8900,
                0,
                6900,
                10200,
                0,
                41.29001909,
                69.179971180
            )
        )
        petrolList.add(
            PetrolFilial(
                id,
                "IBR petroleum station",
                9200,
                8900,
                0,
                6900,
                10200,
                0,
                41.27449540,
                69.1672426
            )
        )

    }

    override fun getServiceList(): ArrayList<AutoService> {
        return serviceList
    }

    override fun getCarWashList(): ArrayList<CarWash> {
        return carWashList
    }

    override fun getPetrolList(): ArrayList<PetrolFilial> {
        return petrolList
    }

    override fun getServiceById(id: Int): AutoService {
        for (autoService in serviceList) {
            if (autoService.id == id) return autoService
        }
        return AutoService(0, "", ArrayList(), 0.0, 0.0)
    }

    override fun getCarWashById(id: Int): CarWash {
        for (carWash in carWashList) {
            if (carWash.id == id) return carWash
        }
        return CarWash(0, "", ArrayList(), 0.0, 0.0)
    }

    override fun getPetrolById(id: Int): PetrolFilial {
        for (petrol in petrolList) {
            if (petrol.id == id) return petrol
        }
        return PetrolFilial(0, "", 0, 0, 0, 0, 0, 0, 0.0, 0.0)
    }
}