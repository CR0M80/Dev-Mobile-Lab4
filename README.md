# 📋 FragmentsLab — By SAAD

Application Android démontrant l’utilisation des **fragments dynamiques**, la navigation entre eux et la gestion des interactions utilisateur.

---

## 📽️ Démonstration

https://github.com/user-attachments/assets/7db6420d-1647-413d-a859-ee0998b869ec

---

# 🖼️ Interface — `res/layout/activity_main.xml`

## 🎯 Structure principale

```xml
<LinearLayout orientation="vertical">
    <!-- Header -->
    <!-- Boutons navigation -->
    <!-- Container fragments -->
</LinearLayout>
```

### 🔘 Boutons de navigation

```xml
<Button
    android:id="@+id/btnFragment1"
    android:text="Fragment 1"
    android:backgroundTint="#3B82F6"/>

<Button
    android:id="@+id/btnFragment2"
    android:text="Fragment 2"
    android:backgroundTint="#10B981"/>
```

| Attribut             | Rôle                                     |
| -------------------- | ---------------------------------------- |
| `backgroundTint`     | Couleur moderne (bleu / vert)            |
| `layout_weight`      | Permet aux boutons de prendre 50% chacun |
| `setOnClickListener` | Déclenche le changement de fragment      |

---

### 🧩 Conteneur de fragments

```xml
<FrameLayout
    android:id="@+id/fragment_container"/>
```

👉 Zone dynamique où les fragments sont affichés/remplacés.

---

# 🖼️ Interface — `fragment_one.xml`

### 🧾 Texte + bouton

```xml
<TextView
    android:id="@+id/textOne"
    android:text="👋 Fragment One"/>

<Button
    android:id="@+id/btnHello"
    android:text="Dire bonjour 🚀"/>
```

👉 Interface simple pour tester les interactions utilisateur.

---

# 🖼️ Interface — `fragment_two.xml`

### 🎚 SeekBar + affichage dynamique

```xml
<TextView
    android:id="@+id/tvValue"
    android:text="🎚 Valeur : 0"/>

<SeekBar
    android:id="@+id/seekBar"
    android:max="100"/>
```

👉 Permet de manipuler une valeur en temps réel.

---

# ☕ Logique — `MainActivity.java`

## 🔄 Navigation entre fragments

```java
replaceFragment(new FragmentOne(), false);
```

### Méthode principale

```java
private void replaceFragment(Fragment fragment, boolean back)
```

| Méthode               | Rôle                         |
| --------------------- | ---------------------------- |
| `FragmentManager`     | Gère les fragments           |
| `FragmentTransaction` | Applique les changements     |
| `replace()`           | Remplace le fragment affiché |
| `addToBackStack()`    | Permet le retour arrière     |
| `commit()`            | Valide la transaction        |

---

### 🧠 Navigation

```java
btn1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));
btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
```

👉 Clique bouton → remplacement du fragment dans le container.

---

# ☕ Logique — `FragmentOne.java`

## 🎯 Interaction utilisateur

```java
btn.setOnClickListener(v -> {
    tv.setText("🔥 Bonjour depuis Fragment 1 !");
});
```

👉 Mise à jour dynamique du texte après clic.

---

## 🔍 Cycle de vie (Logcat)

```java
@Override
public void onResume() {
    Log.d("FragmentOne", "onResume()");
}

@Override
public void onPause() {
    Log.d("FragmentOne", "onPause()");
}
```

👉 Permet d’observer :

* affichage du fragment
* mise en pause lors du changement

---

# ☕ Logique — `FragmentTwo.java`

## 🎚 Gestion du SeekBar

```java
seekBar.setOnSeekBarChangeListener(...)
```

👉 Capture la valeur en temps réel.

---

## 🔄 Mise à jour du texte

```java
tv.setText("🎚 Valeur : " + progress);
```

---

## 🎨 Changement de couleur dynamique

```java
if (progress < 30) tv.setTextColor(Color.RED);
else if (progress < 70) tv.setTextColor(Color.YELLOW);
else tv.setTextColor(Color.GREEN);
```

👉 Feedback visuel selon la valeur.

---

## 💾 Sauvegarde de l’état

```java
outState.putInt("progress", progressValue);
```

👉 Conserve la valeur après rotation écran.

---

# 🧠 Fonctionnement global

### 🔁 Flux utilisateur

| Action              | Résultat                       |
| ------------------- | ------------------------------ |
| App lancement       | Fragment 1 affiché             |
| Clic "Fragment 2"   | Fragment 2 remplace Fragment 1 |
| Bouton Back         | Retour Fragment 1              |
| Interaction SeekBar | Valeur mise à jour en direct   |

---

# 📚 Concepts clés

| Concept               | Explication                    |
| --------------------- | ------------------------------ |
| Fragment              | Composant UI réutilisable      |
| FragmentManager       | Gestion des fragments          |
| FragmentTransaction   | Actions (add, replace, remove) |
| addToBackStack()      | Historique navigation          |
| onViewCreated()       | Initialisation UI              |
| onSaveInstanceState() | Sauvegarde temporaire          |

---

*Projet réalisé dans le cadre d’un apprentissage Android — SAAD* 🚀
