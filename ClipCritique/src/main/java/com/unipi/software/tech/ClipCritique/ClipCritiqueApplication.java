package com.unipi.software.tech.ClipCritique;

import com.unipi.software.tech.ClipCritique.model.*;
import com.unipi.software.tech.ClipCritique.repository.QuestionnaireRepository;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import com.unipi.software.tech.ClipCritique.repository.WatchHistoryRepository;
import com.unipi.software.tech.ClipCritique.service.QuestionnaireService;
import com.unipi.software.tech.ClipCritique.service.WatchHistoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class ClipCritiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClipCritiqueApplication.class, args);
    }


    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList(
                        "http://localhost:3000"
                )
        );
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository, VideoRepository videoRepository, QuestionnaireRepository questionnaireRepository, WatchHistoryRepository watchHistoryRepository, WatchHistoryService watchHistoryService) {
        return args -> {

            var admin = User.builder()
                    .fullName("Admin")
                    .email("cineticketbooking@gmail.com")
                    .password("12345")
                    .dateOfBirth(LocalDate.of(1999, 6, 6))
                    .role(Role.ADMIN)
                    .build();

            userRepository.save(admin);

            var admin0 = User.builder().fullName("Brett Ahrenholz").email("test0@gmail.com").password("12345").dateOfBirth(LocalDate.of(1970, 9, 5)).role(Role.USER).build();
            userRepository.save(admin0);
            var admin1 = User.builder().fullName("Ellis Abdin").email("test1@gmail.com").password("12345").dateOfBirth(LocalDate.of(2001, 3, 29)).role(Role.USER).build();
            userRepository.save(admin1);
            var admin2 = User.builder().fullName("Emanuel Ahmad").email("test2@gmail.com").password("12345").dateOfBirth(LocalDate.of(1971, 6, 22)).role(Role.USER).build();
            userRepository.save(admin2);
            var admin3 = User.builder().fullName("Cillian Aivao").email("test3@gmail.com").password("12345").dateOfBirth(LocalDate.of(1972, 8, 30)).role(Role.USER).build();
            userRepository.save(admin3);
            var admin4 = User.builder().fullName("Aedyn Alagna").email("test4@gmail.com").password("12345").dateOfBirth(LocalDate.of(2012, 6, 25)).role(Role.USER).build();
            userRepository.save(admin4);
            var admin5 = User.builder().fullName("Aryian Ahlo").email("test5@gmail.com").password("12345").dateOfBirth(LocalDate.of(1973, 6, 15)).role(Role.USER).build();
            userRepository.save(admin5);
            var admin6 = User.builder().fullName("Azzedine Aleo").email("test6@gmail.com").password("12345").dateOfBirth(LocalDate.of(1987, 12, 9)).role(Role.USER).build();
            userRepository.save(admin6);
            var admin7 = User.builder().fullName("Adrian Addo").email("test7@gmail.com").password("12345").dateOfBirth(LocalDate.of(2002, 8, 23)).role(Role.USER).build();
            userRepository.save(admin7);
            var admin8 = User.builder().fullName("Ethan Aderman").email("test8@gmail.com").password("12345").dateOfBirth(LocalDate.of(2019, 7, 19)).role(Role.USER).build();
            userRepository.save(admin8);
            var admin9 = User.builder().fullName("Angelo Abood").email("test9@gmail.com").password("12345").dateOfBirth(LocalDate.of(1997, 3, 14)).role(Role.USER).build();
            userRepository.save(admin9);
            var admin10 = User.builder().fullName("Dennys Alexiou").email("test10@gmail.com").password("12345").dateOfBirth(LocalDate.of(2002, 7, 17)).role(Role.USER).build();
            userRepository.save(admin10);
            var admin11 = User.builder().fullName("Calean Aharon").email("test11@gmail.com").password("12345").dateOfBirth(LocalDate.of(2018, 5, 7)).role(Role.USER).build();
            userRepository.save(admin11);
            var admin12 = User.builder().fullName("Ammer Aievoli").email("test12@gmail.com").password("12345").dateOfBirth(LocalDate.of(2003, 8, 7)).role(Role.USER).build();
            userRepository.save(admin12);
            var admin13 = User.builder().fullName("Alber Affolter").email("test13@gmail.com").password("12345").dateOfBirth(LocalDate.of(1972, 1, 22)).role(Role.USER).build();
            userRepository.save(admin13);
            var admin14 = User.builder().fullName("Eduardo Ajose").email("test14@gmail.com").password("12345").dateOfBirth(LocalDate.of(1962, 3, 18)).role(Role.USER).build();
            userRepository.save(admin14);
            var admin15 = User.builder().fullName("Aria Aguliar").email("test15@gmail.com").password("12345").dateOfBirth(LocalDate.of(1988, 3, 10)).role(Role.USER).build();
            userRepository.save(admin15);
            var admin16 = User.builder().fullName("Conlly Abalos").email("test16@gmail.com").password("12345").dateOfBirth(LocalDate.of(1982, 10, 28)).role(Role.USER).build();
            userRepository.save(admin16);
            var admin17 = User.builder().fullName("Chimsom Accurso").email("test17@gmail.com").password("12345").dateOfBirth(LocalDate.of(2015, 11, 11)).role(Role.USER).build();
            userRepository.save(admin17);
            var admin18 = User.builder().fullName("David-Lee Akhand").email("test18@gmail.com").password("12345").dateOfBirth(LocalDate.of(1987, 5, 3)).role(Role.USER).build();
            userRepository.save(admin18);
            var admin19 = User.builder().fullName("Aleksandr Albers").email("test19@gmail.com").password("12345").dateOfBirth(LocalDate.of(1989, 5, 11)).role(Role.USER).build();
            userRepository.save(admin19);
            var admin20 = User.builder().fullName("Amos Ahlo").email("test20@gmail.com").password("12345").dateOfBirth(LocalDate.of(1994, 12, 17)).role(Role.USER).build();
            userRepository.save(admin20);
            var admin21 = User.builder().fullName("Chris-Daniel Ables").email("test21@gmail.com").password("12345").dateOfBirth(LocalDate.of(1989, 2, 7)).role(Role.USER).build();
            userRepository.save(admin21);
            var admin22 = User.builder().fullName("Aedyn Abate").email("test22@gmail.com").password("12345").dateOfBirth(LocalDate.of(1987, 6, 21)).role(Role.USER).build();
            userRepository.save(admin22);
            var admin23 = User.builder().fullName("Ami Adelizzi").email("test23@gmail.com").password("12345").dateOfBirth(LocalDate.of(1974, 5, 28)).role(Role.USER).build();
            userRepository.save(admin23);
            var admin24 = User.builder().fullName("Carlo Addison").email("test24@gmail.com").password("12345").dateOfBirth(LocalDate.of(1986, 9, 9)).role(Role.USER).build();
            userRepository.save(admin24);
            var admin25 = User.builder().fullName("Elijah Ainsworth").email("test25@gmail.com").password("12345").dateOfBirth(LocalDate.of(2004, 3, 26)).role(Role.USER).build();
            userRepository.save(admin25);
            var admin26 = User.builder().fullName("Ayman Aldapa").email("test26@gmail.com").password("12345").dateOfBirth(LocalDate.of(1994, 10, 5)).role(Role.USER).build();
            userRepository.save(admin26);
            var admin27 = User.builder().fullName("Caelan Accola").email("test27@gmail.com").password("12345").dateOfBirth(LocalDate.of(1961, 7, 13)).role(Role.USER).build();
            userRepository.save(admin27);
            var admin28 = User.builder().fullName("Believe Aholt").email("test28@gmail.com").password("12345").dateOfBirth(LocalDate.of(1968, 11, 4)).role(Role.USER).build();
            userRepository.save(admin28);
            var admin29 = User.builder().fullName("Bekim Ahrens").email("test29@gmail.com").password("12345").dateOfBirth(LocalDate.of(1990, 10, 5)).role(Role.USER).build();
            userRepository.save(admin29);
            var admin30 = User.builder().fullName("Aiden-Jack Adwell").email("test30@gmail.com").password("12345").dateOfBirth(LocalDate.of(2012, 8, 17)).role(Role.USER).build();
            userRepository.save(admin30);
            var admin31 = User.builder().fullName("Derrie Abbassi").email("test31@gmail.com").password("12345").dateOfBirth(LocalDate.of(1991, 3, 18)).role(Role.USER).build();
            userRepository.save(admin31);
            var admin32 = User.builder().fullName("Christian Acker").email("test32@gmail.com").password("12345").dateOfBirth(LocalDate.of(2006, 12, 12)).role(Role.USER).build();
            userRepository.save(admin32);
            var admin33 = User.builder().fullName("Arrham Aldrow").email("test33@gmail.com").password("12345").dateOfBirth(LocalDate.of(1962, 2, 4)).role(Role.USER).build();
            userRepository.save(admin33);
            var admin34 = User.builder().fullName("Findlay Aggers").email("test34@gmail.com").password("12345").dateOfBirth(LocalDate.of(1982, 4, 2)).role(Role.USER).build();
            userRepository.save(admin34);
            var admin35 = User.builder().fullName("Dermot Agosto").email("test35@gmail.com").password("12345").dateOfBirth(LocalDate.of(1962, 1, 4)).role(Role.USER).build();
            userRepository.save(admin35);
            var admin36 = User.builder().fullName("Felix Adjei").email("test36@gmail.com").password("12345").dateOfBirth(LocalDate.of(2004, 5, 10)).role(Role.USER).build();
            userRepository.save(admin36);
            var admin37 = User.builder().fullName("Baley Aerts").email("test37@gmail.com").password("12345").dateOfBirth(LocalDate.of(1975, 1, 30)).role(Role.USER).build();
            userRepository.save(admin37);
            var admin38 = User.builder().fullName("Anubhav Acee").email("test38@gmail.com").password("12345").dateOfBirth(LocalDate.of(2004, 11, 24)).role(Role.USER).build();
            userRepository.save(admin38);
            var admin39 = User.builder().fullName("Beinn Acampora").email("test39@gmail.com").password("12345").dateOfBirth(LocalDate.of(2020, 6, 10)).role(Role.USER).build();
            userRepository.save(admin39);
            var admin40 = User.builder().fullName("Cory Achter").email("test40@gmail.com").password("12345").dateOfBirth(LocalDate.of(1998, 7, 19)).role(Role.USER).build();
            userRepository.save(admin40);
            var admin41 = User.builder().fullName("Cosmo Afoa").email("test41@gmail.com").password("12345").dateOfBirth(LocalDate.of(2019, 3, 29)).role(Role.USER).build();
            userRepository.save(admin41);
            var admin42 = User.builder().fullName("Bader Ackermann").email("test42@gmail.com").password("12345").dateOfBirth(LocalDate.of(1993, 1, 30)).role(Role.USER).build();
            userRepository.save(admin42);
            var admin43 = User.builder().fullName("Dagon Akim").email("test43@gmail.com").password("12345").dateOfBirth(LocalDate.of(2002, 9, 13)).role(Role.USER).build();
            userRepository.save(admin43);
            var admin44 = User.builder().fullName("Deshawn Abramoff").email("test44@gmail.com").password("12345").dateOfBirth(LocalDate.of(2012, 7, 30)).role(Role.USER).build();
            userRepository.save(admin44);
            var admin45 = User.builder().fullName("Eng Abramov").email("test45@gmail.com").password("12345").dateOfBirth(LocalDate.of(2008, 8, 17)).role(Role.USER).build();
            userRepository.save(admin45);
            var admin46 = User.builder().fullName("Archibald Ahimud").email("test46@gmail.com").password("12345").dateOfBirth(LocalDate.of(1971, 9, 1)).role(Role.USER).build();
            userRepository.save(admin46);
            var admin47 = User.builder().fullName("Clifford Abellera").email("test47@gmail.com").password("12345").dateOfBirth(LocalDate.of(1982, 3, 11)).role(Role.USER).build();
            userRepository.save(admin47);
            var admin48 = User.builder().fullName("Bharath Adalja").email("test48@gmail.com").password("12345").dateOfBirth(LocalDate.of(1998, 11, 24)).role(Role.USER).build();
            userRepository.save(admin48);
            var admin49 = User.builder().fullName("Diesil Ackah").email("test49@gmail.com").password("12345").dateOfBirth(LocalDate.of(1973, 10, 28)).role(Role.USER).build();
            userRepository.save(admin49);


            Video video1 = new Video("https://www.youtube.com/embed/2Vv-BfVoq4g?si=1UGc-d43dyflHIUb", admin, "Perfect", VideoCategory.LoveSongs, 8, "Ed Sheeran");
            videoRepository.save(video1);
            Video video2 = new Video("https://www.youtube.com/embed/xeWRGDB5iWM?si=Vja1rOfi5pe4T5qS", admin, "STILL STANDING", VideoCategory.Rap, 16, "12os Pithikos & Dani Gambino");
            videoRepository.save(video2);
            Video video3 = new Video("https://www.youtube.com/embed/knfrxj0T5NY?si=hMbSgv82Y2RFGDKQ", admin, "Bad Karma", VideoCategory.Trap, 14, "Axel Thesleff");
            videoRepository.save(video3);
            Video video4 = new Video("https://www.youtube.com/embed/tAGnKpE4NCI?si=jzIcDsyLiWGLAMxh", admin, "Nothing Else Matters", VideoCategory.GreekLaika, 18, "Metallica");
            videoRepository.save(video4);
            Video video5 = new Video("https://www.youtube.com/embed/vrFnIf0VPDE?si=A-4e3qOhP3ijVAT-", admin, "Ηπειρώτισσα Ξανθιά", VideoCategory.Hpeirwtika, 12, "Γιάννης Καψάλης");
            videoRepository.save(video5);
            Video video6 = new Video("https://www.youtube.com/embed/5urt0fNYHWA?si=GWV1uK8HkJm94y0w", admin, "Θα αλλάξω γειτονιά", VideoCategory.Tsamiko, 12, "Γιώργος Βελισσάρης");
            videoRepository.save(video6);
            Video video7 = new Video("https://www.youtube.com/embed/X4bgXH3sJ2Q?si=xHCvpuBdsRLb7JSl", admin, "The Trooper", VideoCategory.Metal, 18, "Iron Maiden");
            videoRepository.save(video7);
            Video video8 = new Video("https://www.youtube.com/embed/5oc3DbkCXtI?si=dUSkCEp7D1Wr7uw5", admin, "Αεροπλάνο", VideoCategory.Pop, 14, "Ελένη Φουρέιρα & FY");
            videoRepository.save(video8);
            Video video9 = new Video("https://www.youtube.com/embed/9bZkp7q19f0?si=cUgmN0h2VWDOFRYi", admin, "Gangnam Style", VideoCategory.Kpop, 13, "PSY");
            videoRepository.save(video9);
            Video video10 = new Video("https://www.youtube.com/embed/nfWlot6h_JM?si=mUK8t3-kQDhponqY", admin, "Shake It Off", VideoCategory.Pop, 12, "Taylor Swift");
            videoRepository.save(video10);
            Video video11 = new Video("https://www.youtube.com/embed/wMf8Xytxfpk?si=O9EU8PnRkK12QDmc", admin, "Έρωτας Αρχάγγελος", VideoCategory.Zeimpekiko, 17, "Δημήτρης Μητροπάνος ");
            videoRepository.save(video11);
            Video video12 = new Video("https://www.youtube.com/embed/xFYQQPAOz7Y?si=g8dLIusN-9Zmqgtr", admin, "Lose Yourself", VideoCategory.Rap, 18, "Eminem");
            videoRepository.save(video12);
            Video video13 = new Video("https://www.youtube.com/embed/Pi3_Zs-oRUo?si=WRypphBiGz12tpG7", admin, "Till I Collapse", VideoCategory.Rap, 12, "Eminem");
            videoRepository.save(video13);
            Video video14 = new Video("https://www.youtube.com/embed/b0z_dp5-luQ?si=ICHmgenTbJTZznSy", admin, "Έκπτωτος Άγγελος", VideoCategory.LoveSongs, 15, "Νίκος Οικονόπουλος");
            videoRepository.save(video14);
            Video video15 = new Video("https://www.youtube.com/embed/Y1xs_xPb46M?si=FGHWhfcE71w3EqPB", admin, "One Thing", VideoCategory.Pop, 12, "One Direction");
            videoRepository.save(video15);
            Video video16 = new Video("https://www.youtube.com/embed/OdxSbc0ap-s?si=RhDyMHfDDh4yL1mM", admin, "Mamushi", VideoCategory.Trap, 18, "Megan Thee Stallion");
            videoRepository.save(video16);
            Video video17 = new Video("https://www.youtube.com/embed/t_GA9a9fcRE?si=nn6h4BG_F16uzksc", admin, "Στην Πάρο Και Στην Νάξο", VideoCategory.NisiotikaMusic, 8, "Γιάννης Πάριος");
            videoRepository.save(video17);
            Video video18 = new Video("https://www.youtube.com/embed/cWc7vYjgnTs?si=41qZPVO6CEeiypIE", admin, "Nessun dorma", VideoCategory.Opera, 17, "Luciano Pavarotti");
            videoRepository.save(video18);
            Video video19 = new Video("https://www.youtube.com/embed/YSPmB7rridY?si=fwkMaXtH0kHqpdcs", admin, "Πως Περάσανε Τα Χρόνια", VideoCategory.Tsamiko, 8, "Φιλιώ Πυργάκη");
            videoRepository.save(video19);
            Video video20 = new Video("https://www.youtube.com/embed/OZCk-eLACu4?si=sVu-c0moIR0Mt4Wc", admin, "Πανεπιστήμιο Πειραιώς", VideoCategory.Other, 18, "University of Piraeus");
            videoRepository.save(video20);
            Video video21 = new Video("https://www.youtube.com/embed/tmk5GV9ro0w?si=lDaa6jYxhNWdvv4r", admin, "ΟΙ ΚΛΕΦΤΕΣ ΑΠΟ ΤΟΝ ΑΛΕΚΟ ΚΙΤΣΑΚΗ", VideoCategory.Hpeirwtika, 15, "Ηπειρώτικα");
            videoRepository.save(video21);
            Video video22 = new Video("https://www.youtube.com/embed/rs6Y4kZ8qtw?si=mA8v5khbsAVj8w-P", admin, "Me Gustas Tu", VideoCategory.Trap, 18, "Manu Chao");
            videoRepository.save(video22);
            Video video23 = new Video("https://www.youtube.com/embed/GzU8KqOY8YA?si=EB0WMaYVx06smvys", admin, "No Lie", VideoCategory.Pop, 16, "Sean Paul & Dua Lipa");
            videoRepository.save(video23);
            Video video24 = new Video("https://www.youtube.com/embed/2S24-y0Ij3Y?si=VFuhqg4fcZtZoUg8", admin, "Kill This Love", VideoCategory.Kpop, 14, "BLACKPINK");
            videoRepository.save(video24);
            Video video25 = new Video("https://www.youtube.com/embed/562OwXu_yug?si=w9AC9VVD0dhumMBo", admin, "Μπεράτι Αργό", VideoCategory.Hpeirwtika, 12, "Ήπειρος");
            videoRepository.save(video25);
            Video video26 = new Video("https://www.youtube.com/embed/Roltz_Q_lQ4?si=wYEQb7ub4AhyqOte", admin, "Ικαριώτικο", VideoCategory.NisiotikaMusic, 12, "Γιάννης Πάριος");
            videoRepository.save(video26);
            Video video27 = new Video("https://www.youtube.com/embed/QtjN1hE-erU?si=-2sqVk5-f4ciyDcA", admin, "Ένας Αητός", VideoCategory.NisiotikaMusic, 12, "Γιάννης Κατέβας");
            videoRepository.save(video27);
            Video video28 = new Video("https://www.youtube.com/embed/yeC7N80wZas?si=3ldcb-zV1vRKSvBg", admin, "Το Ζεϊμπέκικο της Ευδοκίας", VideoCategory.Zeimpekiko, 17, "ZEIBEKIKO OF EVDOKIA");
            videoRepository.save(video28);
            Video video29 = new Video("https://www.youtube.com/embed/omltwZ8tGoE?si=vBjpd5lxD6en0lxS", admin, "Φίλα με Ακόμα", VideoCategory.LoveSongs, 16, "Πάνος Μουζουράκης & Μαραβέγιας");
            videoRepository.save(video29);
            Video video30 = new Video("https://www.youtube.com/embed/8HJ9Ik46Kbc?si=WD-Rp1PviTywsIDf", admin, "ΠΜΣ Προηγμένα Συστήματα Πληροφορικής - Ανάπτυξη Λογισμικού και Τεχνητής Νοημοσύνης", VideoCategory.Other, 18, "Πανεπιστήμιο Πειραιώς");
            videoRepository.save(video30);
            Video video31 = new Video("https://www.youtube.com/embed/eJ4i-QbXG54?si=3QcDTYFAytwQJcPC", admin, "Stand By Me", VideoCategory.LoveSongs, 16, "Ben E. King");
            videoRepository.save(video31);
            Video video32 = new Video("https://www.youtube.com/embed/pgz6PnHkmpY?si=UK2zSeliLz-nwxjd", admin, "The Phantom of the Opera", VideoCategory.Opera, 17, "Emmy Rossum & Gerard Butler");
            videoRepository.save(video32);
            Video video33 = new Video("https://www.youtube.com/embed/5abamRO41fE?si=MWDFF8lWAsJ6cpBq", admin, "Psychosocial", VideoCategory.Metal, 18, "Slipknot");
            videoRepository.save(video33);
            Video video34 = new Video("https://www.youtube.com/embed/iywaBOMvYLI?si=qfmoQ3TfS7bk9CjO", admin, "Toxicity", VideoCategory.Metal, 17, "System Of A Down");
            videoRepository.save(video34);
            Video video35 = new Video("https://www.youtube.com/embed/GXs23OOCGW0?si=a_Kg4kyoBTajD6mX", admin, "Μαζί Σου", VideoCategory.LoveSongs, 15, "Κωνσταντίνος Αργυρός");
            videoRepository.save(video35);
            Video video36 = new Video("https://www.youtube.com/embed/r0CmpaSV0tc?si=SWVMO5tDU-fBorUr", admin, "My Number One", VideoCategory.Pop, 11, "Helena Paparizou");
            videoRepository.save(video36);
            Video video37 = new Video("https://www.youtube.com/embed/055u8ITcLgg?si=pNXYx1nwXYwjqk0C", admin, "Παπαλάμπραινα", VideoCategory.Tsamiko, 12, "Τσάμικος");
            videoRepository.save(video37);
            Video video38 = new Video("https://www.youtube.com/embed/maxF8byxsSQ?si=ydYEy_5butdFm9f4", admin, "Λάθη Μετράω", VideoCategory.Rap, 16, "Εισβολέας & Σεμέλη Παπαβασιλείου");
            videoRepository.save(video38);
            Video video39 = new Video("https://www.youtube.com/embed/1Ba3fOvlruU?si=NkJT199GsvsHVzUj", admin, "Αθήνα Μου", VideoCategory.Zeimpekiko, 16, "Κωνσταντίνος Αργυρός");
            videoRepository.save(video39);
            Video video40 = new Video("https://www.youtube.com/embed/b7kxtIGaNpw?si=WvgVbVLGJfbTc6Pz", admin, "Lose Control", VideoCategory.Trap, 15, "MEDUZA, Becky Hill & Goodboys");
            videoRepository.save(video40);
            Video video41 = new Video("https://www.youtube.com/embed/nYM4o4yUJIE?si=SxO1GC5p6MEsDwth", admin, "Πάντα καλοκαίρι", VideoCategory.Pop, 14, "VEGAS");
            videoRepository.save(video41);
            Video video42 = new Video("https://www.youtube.com/embed/aNUBuDPAk_I?si=xHJQ-rCSjbG4Hnbd", admin, "Μες στου Αιγαίου τα νησιά", VideoCategory.NisiotikaMusic, 12, "Λέτα Κορρέ");
            videoRepository.save(video42);
            Video video43 = new Video("https://www.youtube.com/embed/xEeFrLSkMm8?si=LaOLzdz8A89nwSnx", admin, "Spring Day", VideoCategory.Kpop, 14, "BTS");
            videoRepository.save(video43);
            Video video44 = new Video("https://www.youtube.com/embed/Cf2aYd4pAsI?si=whxhXDZ9pvbEIhIq", admin, "Ένας λεβέντης χόρευε", VideoCategory.Tsamiko, 11, "Τσάμικο Θεσσαλίας");
            videoRepository.save(video44);
            Video video45 = new Video("https://www.youtube.com/embed/N0VdRLdg2ng?si=JPqTidwziVrU9V9k", admin, "Californa Love", VideoCategory.Rap, 17, "2PAC");
            videoRepository.save(video45);
            Video video46 = new Video("https://www.youtube.com/embed/Rtf6vJ_aUTM?si=wyeKHoqdSzAXQRlb", admin, "Κερκυρα τραγουδι", VideoCategory.NisiotikaMusic, 11, "Corfu song");
            videoRepository.save(video46);
            Video video47 = new Video("https://www.youtube.com/embed/Uau48wh5CeI?si=I-iZ6tC2kbpHgwXt", admin, "Turandot: Nessun Dorma", VideoCategory.Opera, 14, "Puccini");
            videoRepository.save(video47);
            Video video48 = new Video("https://www.youtube.com/embed/WWFjlPAHwoM?si=DqtN6js5Gb3m0z6d", admin, "Ice Cream", VideoCategory.Kpop, 17, "JEON SOMI");
            videoRepository.save(video48);
            Video video49 = new Video("https://www.youtube.com/embed/AkFqg5wAuFk?si=2VMFXkZ0UiR5QDPv", admin, "Walk", VideoCategory.Metal, 17, "Pantera");
            videoRepository.save(video49);
            Video video50 = new Video("https://www.youtube.com/embed/PxZJzuVG6W8?si=rD4EpGrtG_TVHiWx", admin, "Rigoletto: La Donna E Mobile", VideoCategory.Opera, 14, "Verdi");
            videoRepository.save(video50);
            Video video51 = new Video("https://www.youtube.com/embed/Amq-qlqbjYA?si=KI_TacfQqr4a5ZhT", admin, "AS IF IT'S YOUR LAST", VideoCategory.Kpop, 13, "BLACPINK");
            videoRepository.save(video51);
            Video video52 = new Video("https://www.youtube.com/embed/CehYA3omb5o?si=oJ8lXWDZhSzcH_H5", admin, "Ænema", VideoCategory.Metal, 17, "TOOL");
            videoRepository.save(video52);
            Video video53 = new Video("https://www.youtube.com/embed/8rjMS13CgT4?si=Cryi5TgBWnz7oP0v", admin, "Xerxes: Ombra Mai Fu", VideoCategory.Opera, 14, "Handel");
            videoRepository.save(video53);
            Video video54 = new Video("https://www.youtube.com/embed/V2hlQkVJZhE?si=qk5GVumcqwu6hfrR", admin, "LIKEY", VideoCategory.Kpop, 14, "TWICE");
            videoRepository.save(video54);
            Video video55 = new Video("https://www.youtube.com/embed/0LgkkwyUK_A?si=F6CG6jr0w9beNMLR", admin, "The Marriage of Figaro: Overture", VideoCategory.Opera, 16, "Mozzart");
            videoRepository.save(video55);
            Video video56 = new Video("https://www.youtube.com/embed/az5UHRBndac?si=6zndPdNRLhMrr097", admin, "Βαλτέτσιά", VideoCategory.Tsamiko, 12, "Βαλτέτσι");
            videoRepository.save(video56);
            Video video57 = new Video("https://www.youtube.com/embed/nxeeRj3hmiQ?si=fXVELHH9H-ikUEFR", admin, "ΞΥΠΝΑ ΠΕΡΔΙΚΟΜΑΤΑ ΜΟΥ", VideoCategory.Hpeirwtika, 12, "Ηπειρώτικα");
            videoRepository.save(video57);
            Video video58 = new Video("https://www.youtube.com/embed/2sW-AbrCWU0?si=Es07H-qKyemmxEqq", admin, "Απόψε Θέλω Να Πιώ", VideoCategory.Zeimpekiko, 16, "Χάρις Αλεξίου");
            videoRepository.save(video58);
            Video video59 = new Video("https://www.youtube.com/embed/Odu7P4lipic?si=euYY_qu-ZBT1IqPm", admin, "Ξενιτεμένα μου πουλιά", VideoCategory.Hpeirwtika, 12, "Ηπειρώτικα");
            videoRepository.save(video59);
            Video video60 = new Video("https://www.youtube.com/embed/cXqeaDoe7Pk?si=JZ31-5z8Fb_xatU-", admin, "Ώρες Μικρές", VideoCategory.Zeimpekiko, 17, "Γιώργος Μαζωνάκης");
            videoRepository.save(video60);




















            Questionnaire questionnaire = new Questionnaire(VideoCategory.Rap, VideoCategory.LoveSongs, VideoCategory.Trap, 1L, 2L, 3L, admin);
            questionnaireRepository.save(questionnaire);

            WatchHistory watchhistory0 = new WatchHistory(-1L, admin13, video1, "", -1);
            watchHistoryService.addNewHistory(watchhistory0);
            WatchHistory watchhistory1 = new WatchHistory(-1L, admin24, video2, "", 4);
            watchHistoryService.addNewHistory(watchhistory1);
            WatchHistory watchhistory2 = new WatchHistory(-1L, admin45, video12, "", 5);
            watchHistoryService.addNewHistory(watchhistory2);
            WatchHistory watchhistory3 = new WatchHistory(-1L, admin40, video19, "", 0);
            watchHistoryService.addNewHistory(watchhistory3);
            WatchHistory watchhistory4 = new WatchHistory(-1L, admin22, video6, "", 5);
            watchHistoryService.addNewHistory(watchhistory4);
            WatchHistory watchhistory5 = new WatchHistory(-1L, admin41, video16, "", 0);
            watchHistoryService.addNewHistory(watchhistory5);
            WatchHistory watchhistory6 = new WatchHistory(-1L, admin23, video5, "", 3);
            watchHistoryService.addNewHistory(watchhistory6);
            WatchHistory watchhistory7 = new WatchHistory(-1L, admin7, video10, "", 4);
            watchHistoryService.addNewHistory(watchhistory7);
            WatchHistory watchhistory8 = new WatchHistory(-1L, admin10, video6, "", 0);
            watchHistoryService.addNewHistory(watchhistory8);
            WatchHistory watchhistory9 = new WatchHistory(-1L, admin10, video14, "", -1);
            watchHistoryService.addNewHistory(watchhistory9);
            WatchHistory watchhistory10 = new WatchHistory(-1L, admin20, video5, "", 4);
            watchHistoryService.addNewHistory(watchhistory10);
            WatchHistory watchhistory11 = new WatchHistory(-1L, admin29, video11, "", 3);
            watchHistoryService.addNewHistory(watchhistory11);
            WatchHistory watchhistory12 = new WatchHistory(-1L, admin5, video16, "", -1);
            watchHistoryService.addNewHistory(watchhistory12);
            WatchHistory watchhistory13 = new WatchHistory(-1L, admin3, video13, "", 0);
            watchHistoryService.addNewHistory(watchhistory13);
            WatchHistory watchhistory14 = new WatchHistory(-1L, admin17, video12, "", 1);
            watchHistoryService.addNewHistory(watchhistory14);
            WatchHistory watchhistory15 = new WatchHistory(-1L, admin32, video18, "", 0);
            watchHistoryService.addNewHistory(watchhistory15);
            WatchHistory watchhistory16 = new WatchHistory(-1L, admin22, video4, "", -1);
            watchHistoryService.addNewHistory(watchhistory16);
            WatchHistory watchhistory17 = new WatchHistory(-1L, admin35, video17, "", 2);
            watchHistoryService.addNewHistory(watchhistory17);
            WatchHistory watchhistory18 = new WatchHistory(-1L, admin31, video2, "", 3);
            watchHistoryService.addNewHistory(watchhistory18);
            WatchHistory watchhistory19 = new WatchHistory(-1L, admin10, video8, "", 3);
            watchHistoryService.addNewHistory(watchhistory19);
            WatchHistory watchhistory20 = new WatchHistory(-1L, admin8, video16, "", 2);
            watchHistoryService.addNewHistory(watchhistory20);
            WatchHistory watchhistory21 = new WatchHistory(-1L, admin43, video11, "", 5);
            watchHistoryService.addNewHistory(watchhistory21);
            WatchHistory watchhistory22 = new WatchHistory(-1L, admin8, video17, "", 0);
            watchHistoryService.addNewHistory(watchhistory22);
            WatchHistory watchhistory23 = new WatchHistory(-1L, admin19, video18, "", 4);
            watchHistoryService.addNewHistory(watchhistory23);
            WatchHistory watchhistory24 = new WatchHistory(-1L, admin31, video8, "", 0);
            watchHistoryService.addNewHistory(watchhistory24);
            WatchHistory watchhistory25 = new WatchHistory(-1L, admin19, video10, "", 0);
            watchHistoryService.addNewHistory(watchhistory25);
            WatchHistory watchhistory26 = new WatchHistory(-1L, admin10, video9, "", 1);
            watchHistoryService.addNewHistory(watchhistory26);
            WatchHistory watchhistory27 = new WatchHistory(-1L, admin19, video14, "", 3);
            watchHistoryService.addNewHistory(watchhistory27);
            WatchHistory watchhistory28 = new WatchHistory(-1L, admin21, video12, "", 4);
            watchHistoryService.addNewHistory(watchhistory28);
            WatchHistory watchhistory29 = new WatchHistory(-1L, admin14, video8, "", 0);
            watchHistoryService.addNewHistory(watchhistory29);
            WatchHistory watchhistory30 = new WatchHistory(-1L, admin35, video10, "", 3);
            watchHistoryService.addNewHistory(watchhistory30);
            WatchHistory watchhistory31 = new WatchHistory(-1L, admin46, video2, "", 0);
            watchHistoryService.addNewHistory(watchhistory31);
            WatchHistory watchhistory32 = new WatchHistory(-1L, admin11, video10, "", 4);
            watchHistoryService.addNewHistory(watchhistory32);
            WatchHistory watchhistory33 = new WatchHistory(-1L, admin31, video18, "", 3);
            watchHistoryService.addNewHistory(watchhistory33);
            WatchHistory watchhistory34 = new WatchHistory(-1L, admin30, video9, "", 0);
            watchHistoryService.addNewHistory(watchhistory34);
            WatchHistory watchhistory35 = new WatchHistory(-1L, admin47, video14, "", 0);
            watchHistoryService.addNewHistory(watchhistory35);
            WatchHistory watchhistory36 = new WatchHistory(-1L, admin42, video5, "", -1);
            watchHistoryService.addNewHistory(watchhistory36);
            WatchHistory watchhistory37 = new WatchHistory(-1L, admin0, video16, "", -1);
            watchHistoryService.addNewHistory(watchhistory37);
            WatchHistory watchhistory38 = new WatchHistory(-1L, admin6, video8, "", -1);
            watchHistoryService.addNewHistory(watchhistory38);
            WatchHistory watchhistory39 = new WatchHistory(-1L, admin31, video7, "", 3);
            watchHistoryService.addNewHistory(watchhistory39);
            WatchHistory watchhistory40 = new WatchHistory(-1L, admin9, video12, "", 3);
            watchHistoryService.addNewHistory(watchhistory40);
            WatchHistory watchhistory41 = new WatchHistory(-1L, admin48, video7, "", -1);
            watchHistoryService.addNewHistory(watchhistory41);
            WatchHistory watchhistory42 = new WatchHistory(-1L, admin17, video7, "", 4);
            watchHistoryService.addNewHistory(watchhistory42);
            WatchHistory watchhistory43 = new WatchHistory(-1L, admin12, video12, "", 4);
            watchHistoryService.addNewHistory(watchhistory43);
            WatchHistory watchhistory44 = new WatchHistory(-1L, admin3, video20, "", -1);
            watchHistoryService.addNewHistory(watchhistory44);
            WatchHistory watchhistory45 = new WatchHistory(-1L, admin22, video4, "", 3);
            watchHistoryService.addNewHistory(watchhistory45);
            WatchHistory watchhistory46 = new WatchHistory(-1L, admin36, video3, "", 0);
            watchHistoryService.addNewHistory(watchhistory46);
            WatchHistory watchhistory47 = new WatchHistory(-1L, admin20, video8, "", 2);
            watchHistoryService.addNewHistory(watchhistory47);
            WatchHistory watchhistory48 = new WatchHistory(-1L, admin37, video8, "", 0);
            watchHistoryService.addNewHistory(watchhistory48);
            WatchHistory watchhistory49 = new WatchHistory(-1L, admin15, video8, "", 3);
            watchHistoryService.addNewHistory(watchhistory49);
            WatchHistory watchhistory50 = new WatchHistory(-1L, admin38, video15, "", 3);
            watchHistoryService.addNewHistory(watchhistory50);
            WatchHistory watchhistory51 = new WatchHistory(-1L, admin44, video19, "", 4);
            watchHistoryService.addNewHistory(watchhistory51);
            WatchHistory watchhistory52 = new WatchHistory(-1L, admin24, video14, "", 3);
            watchHistoryService.addNewHistory(watchhistory52);
            WatchHistory watchhistory53 = new WatchHistory(-1L, admin12, video20, "", 1);
            watchHistoryService.addNewHistory(watchhistory53);
            WatchHistory watchhistory54 = new WatchHistory(-1L, admin36, video18, "", 5);
            watchHistoryService.addNewHistory(watchhistory54);
            WatchHistory watchhistory55 = new WatchHistory(-1L, admin11, video19, "", 1);
            watchHistoryService.addNewHistory(watchhistory55);
            WatchHistory watchhistory56 = new WatchHistory(-1L, admin22, video8, "", 5);
            watchHistoryService.addNewHistory(watchhistory56);
            WatchHistory watchhistory57 = new WatchHistory(-1L, admin5, video18, "", 2);
            watchHistoryService.addNewHistory(watchhistory57);
            WatchHistory watchhistory58 = new WatchHistory(-1L, admin32, video10, "", 4);
            watchHistoryService.addNewHistory(watchhistory58);
            WatchHistory watchhistory59 = new WatchHistory(-1L, admin23, video12, "", 5);
            watchHistoryService.addNewHistory(watchhistory59);
            WatchHistory watchhistory60 = new WatchHistory(-1L, admin44, video11, "", 0);
            watchHistoryService.addNewHistory(watchhistory60);
            WatchHistory watchhistory61 = new WatchHistory(-1L, admin25, video11, "", 1);
            watchHistoryService.addNewHistory(watchhistory61);
            WatchHistory watchhistory62 = new WatchHistory(-1L, admin33, video17, "", 1);
            watchHistoryService.addNewHistory(watchhistory62);
            WatchHistory watchhistory63 = new WatchHistory(-1L, admin18, video7, "", 5);
            watchHistoryService.addNewHistory(watchhistory63);
            WatchHistory watchhistory64 = new WatchHistory(-1L, admin30, video6, "", 3);
            watchHistoryService.addNewHistory(watchhistory64);
            WatchHistory watchhistory65 = new WatchHistory(-1L, admin1, video4, "", 4);
            watchHistoryService.addNewHistory(watchhistory65);
            WatchHistory watchhistory66 = new WatchHistory(-1L, admin0, video17, "", 3);
            watchHistoryService.addNewHistory(watchhistory66);
            WatchHistory watchhistory67 = new WatchHistory(-1L, admin35, video16, "", 3);
            watchHistoryService.addNewHistory(watchhistory67);
            WatchHistory watchhistory68 = new WatchHistory(-1L, admin16, video18, "", 5);
            watchHistoryService.addNewHistory(watchhistory68);
            WatchHistory watchhistory69 = new WatchHistory(-1L, admin7, video8, "", 5);
            watchHistoryService.addNewHistory(watchhistory69);
            WatchHistory watchhistory70 = new WatchHistory(-1L, admin23, video9, "", 1);
            watchHistoryService.addNewHistory(watchhistory70);
            WatchHistory watchhistory71 = new WatchHistory(-1L, admin6, video15, "", 5);
            watchHistoryService.addNewHistory(watchhistory71);
            WatchHistory watchhistory72 = new WatchHistory(-1L, admin5, video3, "", 1);
            watchHistoryService.addNewHistory(watchhistory72);
            WatchHistory watchhistory73 = new WatchHistory(-1L, admin23, video11, "", 5);
            watchHistoryService.addNewHistory(watchhistory73);
            WatchHistory watchhistory74 = new WatchHistory(-1L, admin38, video17, "", 4);
            watchHistoryService.addNewHistory(watchhistory74);
            WatchHistory watchhistory75 = new WatchHistory(-1L, admin44, video5, "", 5);
            watchHistoryService.addNewHistory(watchhistory75);
            WatchHistory watchhistory76 = new WatchHistory(-1L, admin28, video12, "", -1);
            watchHistoryService.addNewHistory(watchhistory76);
            WatchHistory watchhistory77 = new WatchHistory(-1L, admin10, video8, "", 5);
            watchHistoryService.addNewHistory(watchhistory77);
            WatchHistory watchhistory78 = new WatchHistory(-1L, admin19, video20, "", 1);
            watchHistoryService.addNewHistory(watchhistory78);
            WatchHistory watchhistory79 = new WatchHistory(-1L, admin26, video1, "", 1);
            watchHistoryService.addNewHistory(watchhistory79);
            WatchHistory watchhistory80 = new WatchHistory(-1L, admin15, video8, "", -1);
            watchHistoryService.addNewHistory(watchhistory80);
            WatchHistory watchhistory81 = new WatchHistory(-1L, admin42, video10, "", -1);
            watchHistoryService.addNewHistory(watchhistory81);
            WatchHistory watchhistory82 = new WatchHistory(-1L, admin10, video15, "", 1);
            watchHistoryService.addNewHistory(watchhistory82);
            WatchHistory watchhistory83 = new WatchHistory(-1L, admin31, video12, "", -1);
            watchHistoryService.addNewHistory(watchhistory83);
            WatchHistory watchhistory84 = new WatchHistory(-1L, admin29, video6, "", 5);
            watchHistoryService.addNewHistory(watchhistory84);
            WatchHistory watchhistory85 = new WatchHistory(-1L, admin49, video5, "", 3);
            watchHistoryService.addNewHistory(watchhistory85);
            WatchHistory watchhistory86 = new WatchHistory(-1L, admin16, video16, "", -1);
            watchHistoryService.addNewHistory(watchhistory86);
            WatchHistory watchhistory87 = new WatchHistory(-1L, admin45, video14, "", 3);
            watchHistoryService.addNewHistory(watchhistory87);
            WatchHistory watchhistory88 = new WatchHistory(-1L, admin10, video7, "", 5);
            watchHistoryService.addNewHistory(watchhistory88);
            WatchHistory watchhistory89 = new WatchHistory(-1L, admin0, video20, "", 0);
            watchHistoryService.addNewHistory(watchhistory89);
            WatchHistory watchhistory90 = new WatchHistory(-1L, admin45, video17, "", 4);
            watchHistoryService.addNewHistory(watchhistory90);
            WatchHistory watchhistory91 = new WatchHistory(-1L, admin35, video7, "", 4);
            watchHistoryService.addNewHistory(watchhistory91);
            WatchHistory watchhistory92 = new WatchHistory(-1L, admin38, video8, "", 3);
            watchHistoryService.addNewHistory(watchhistory92);
            WatchHistory watchhistory93 = new WatchHistory(-1L, admin37, video17, "", 3);
            watchHistoryService.addNewHistory(watchhistory93);
            WatchHistory watchhistory94 = new WatchHistory(-1L, admin4, video12, "", 2);
            watchHistoryService.addNewHistory(watchhistory94);
            WatchHistory watchhistory95 = new WatchHistory(-1L, admin47, video6, "", 4);
            watchHistoryService.addNewHistory(watchhistory95);
            WatchHistory watchhistory96 = new WatchHistory(-1L, admin47, video8, "", 4);
            watchHistoryService.addNewHistory(watchhistory96);
            WatchHistory watchhistory97 = new WatchHistory(-1L, admin40, video13, "", 2);
            watchHistoryService.addNewHistory(watchhistory97);
            WatchHistory watchhistory98 = new WatchHistory(-1L, admin15, video1, "", 0);
            watchHistoryService.addNewHistory(watchhistory98);
            WatchHistory watchhistory99 = new WatchHistory(-1L, admin3, video5, "", 5);
            watchHistoryService.addNewHistory(watchhistory99);
            WatchHistory watchhistory = new WatchHistory(-1L, admin, video16, "", -1);
            watchHistoryService.addNewHistory(watchhistory);
            WatchHistory watchhistorya1 = new WatchHistory(-1L, admin, video6, "", -1);
            watchHistoryService.addNewHistory(watchhistorya1);
            WatchHistory watchhistorya2 = new WatchHistory(-1L, admin, video1, "", -1);
            watchHistoryService.addNewHistory(watchhistorya2);
            WatchHistory watchhistorya3 = new WatchHistory(-1L, admin, video3, "", 5);
            watchHistoryService.addNewHistory(watchhistorya3);
            WatchHistory watchhistorya4 = new WatchHistory(-1L, admin, video7, "", 5);
            watchHistoryService.addNewHistory(watchhistorya4);
            WatchHistory watchhistorya5 = new WatchHistory(-1L, admin, video12, "", -1);
            watchHistoryService.addNewHistory(watchhistorya5);
            WatchHistory watchhistorya6 = new WatchHistory(-1L, admin, video8, "", -1);
            watchHistoryService.addNewHistory(watchhistorya6);
            WatchHistory watchhistorya7 = new WatchHistory(-1L, admin, video2, "", -1);
            watchHistoryService.addNewHistory(watchhistorya7);
            WatchHistory watchhistorya8 = new WatchHistory(-1L, admin, video17, "", 5);
            watchHistoryService.addNewHistory(watchhistorya8);
            WatchHistory watchhistorya9 = new WatchHistory(-1L, admin, video5, "", 5);
            watchHistoryService.addNewHistory(watchhistorya9);


        };
    }


}
