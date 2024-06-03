## La Banque Virtuelle

## DISCLAIMER : this code is to be used solely for learning purposes. The author of this code is not liable for the damage it might cause on your computer.

## CLAUSE DE NON-RESPONSABILITÉ : L'auteur de ce code n'est pas responsable des dommages qu'il pourrait causer sur votre ordinateur.

- Ceci est une application JAVA qui fonctionne en ligne de commande. Elle affiche un menu avec des options

1. Crer un nouveau compte
2. Dposer de l'argent
3. Retirer de l'argent
4. Consulter le solde du compte
5. Afficher l'historique des transactions
6. Transfrer de l'argent
7. Quitter l'application
   à sélectionner pour les différentes actions.

- Pour la faire marcher, il faut copier coller le code dans un projet JAVA et faire la commande :

```
java ./App.java
```

- Pour un affichage correct du caractère "€", la dévise de l'application, voici les actions à faire en fonction de votre système opérationnel :

- Dans l'invite de commande Windows : tapez chcp 65001 et appuyez sur Entrée. Cette commande définit la page de codes sur UTF-8.
- Dans Windows PowerShell, tapez $OutputEncoding = [Console]::OutputEncoding = [System.Text.Encoding]::UTF8 et appuyez sur Entrée.
- Terminal Linux/Mac : Assurez-vous que votre terminal est configuré pour utiliser le codage UTF-8. La plupart des terminaux modernes utilisent UTF-8 par défaut. Vous pouvez vérifier les paramètres régionaux actuels à l'aide de la commande locale. Si nécessaire, définissez les paramètres régionaux sur UTF-8 en modifiant votre profil shell (par exemple, .bashrc ou .zshrc) pour inclure export LANG=en_US.UTF-8, puis redémarrez votre terminal.
