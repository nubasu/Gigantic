Growth Tool YML Reference
=====
Growth ToolのYML編集は本ドキュメントをご参照ください。

YML内の各項目について解説します。<br />
Optionalと記載のある項目は省略が可能です。<br />
特に記載のない項目はMandatoryで、設定が必須です。<br />

---

以下は全Growth Toolに共通して設定が必要な項目です。<br />

talk-interval （Optional）
---
お喋り間隔（秒）。1プレイヤーに対し、Growth Toolが喋る間隔を設定します。<br />
複数のGrowth Toolを装備している場合、talk-intervalは各々ではなく共通です。<br />
talk-interval内ではいずれか1種のGrowth Toolのみが喋ります。<br />
未設定または不正な値の場合は120秒間隔となります。<br />

talk-percentage （Optional）
---
お喋り確率（％）。イベント時にGrowth Toolが喋る確率を設定します。<br />
イベントの度にGrowth Toolが喋ると機械的なので、Growth Toolが喋る際にキャンセル判定があります。<br />
その際にtalk-percentageに設定した確率によりお喋りを行う判定をします。<br />
未設定または不正な値の場合は50%となります。<br />

drop-denom （Optional）
---
成長ツールのドロップ率。ブロック破壊時に 1 / drop-denom の確率で入手します。<br />
drop-denomによる抽選に当選後に、どのGrowth Toolをドロップするか再抽選を行います。<br />
未設定または不正な値の場合は1/50000となります。<br />

---

以下は各Growth Toolにそれぞれ設定が必要な項目です。<br />

mebius
---
Growth Tool名称でブロックを作成します。<br />
この名称は他のGrowth Toolと重複しない一意な識別子である必要があります。<br />
また、アイテム追加時のenum定数名に合わせる必要があります。<br />
以降の項目はmebiusブロック内に登録するため、先頭に半角空白を2文字付加してください。<br />

ident
---
識別用固有メッセージ。配列で複数行入力可能。<br />
この文字を持つアイテムをGrowth Toolと認定するためのキーワードです。<br />
このキーワードにより、名前だけ変更されたアイテムとの区別を行っています。<br />

drop-balance （Optional）
---
ドロップバランス。drop-denomによる抽選に当選後に利用されます。<br />
再抽選時に、全てのGrowth Toolのdrop-balanceの合計値と比較し、<br />
drop-balance / 合計値 の確率で入手可能です。<br />
未設定または不正な値の場合は100となります。<br />

exp （Lv1以外Optional）
---
次のアイテムレベルまでの経験値。配列でアイテムレベルごとに設定が必要です。<br />
経験値は1掘削につき1ポイント入手可能です。0を設定した場合は経験値入手ではアイテムレベルは上昇しません。<br />
expを最大レベル数として扱うため、上限レベルでは**必ず最後に0を設定**する必要があります。<br />
未設定または不正な値の場合はアイテムレベル1に上限値0の設定のみとなります。<br />

base （Lv1以外Optional）
---
ベースアイテム。見た目が変更されるタイミングを連想配列で指定します。<br />
lvに変化するレベルを、typeに変更後の見た目を設定することが出来ます。<br />
レベルが重複した場合はどちらが選択されるかは保証しません。<br />

custom1 （Optional）
---
カスタムメッセージ1。レベル毎の配列の中に、複数行の配列を持つ二重配列です。<br />
過去のレベルにおけるカスタムメッセージも含めて、定期的にGrowth Toolが喋る言葉となります。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

custom2 （Optional）
---
カスタムメッセージ2。レベル毎の配列の中に、複数行の配列を持つ二重配列です。<br />
カスタムメッセージ1と異なりGrowth Toolの言葉とはなりません。<br />
Growth Toolのアイテム説明欄に表記されるメッセージです。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

unbreakable （Optional）
---
耐久無限付与レベル。耐久無限が付与されるアイテムレベルを設定します。<br />
0を設定した場合、そのアイテムはアイテムレベルの上昇による耐久無限は設定されません。<br />
未設定または不正な値の場合は0として扱います。<br />

enchant-default （Optional）
---
初期エンチャント。アイテムレベル1の段階で付与するエンチャントを設定します。<br />
typeに[エンチャントの種類](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)、lvにエンチャントレベルを指定します。<br />
未設定または不正な値の場合は無しとして扱います。<br />

enchant （Optional）
---
エンチャント設定。アイテムレベルの上昇に伴い付与するエンチャントを設定します。<br />
アイテムレベル上昇時に、ここで設定した条件に基づいてランダムに1種類のエンチャントが1レベル上昇します。<br />
typeに[エンチャントの種類](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)を指定します。<br />
maxLvにそのエンチャントの付与上限値を、premiseにそのエンチャントを付与開始するアイテムレベルを指定します。<br />
未設定または不正な値の場合は無しとして扱います。<br />

tipsmsg （Optional）
---
固有Tipsメッセージ。時間経過によりこのGrowth Toolのみが喋る可能性のある固有メッセージです。<br />
単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

breakmsg （Optional）
---
整地時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤーの愛称に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

renamemsg （Optional）
---
整地時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

killmsg  （Optional）
---
討伐時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
&lt;monster&gt;タグが使用可能で、モンスター名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

damagemsg （Optional）
---
被ダメージ時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
&lt;monster&gt;タグが使用可能で、モンスター名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

warnmsg （Optional）
---
破損警告時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

destroymsg （Optional）
---
破損時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />

quitmsg （Optional）
---
ログアウト時メッセージ。単一行の配列で、複数登録することが可能です。<br />
&lt;me&gt;タグが使用可能で、命名されたGrowth Tool名に変換されます。<br />
&lt;name&gt;タグが使用可能で、プレイヤー名に変換されます。<br />
未設定の場合は該当メッセージは無しとして扱います。<br />
