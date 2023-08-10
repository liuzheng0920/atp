<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <table border="1" cellpadding="5" cellspacing="0" style="text-align: center;">
        <tr>
            <th>日期</th>
            <th>产品名称</th>
            <#if header.ZZC == true><th>总资产</th></#if>
            <#if header.ZFZ == true><th>总负债</th></#if>
            <#if header.ZCJZ == true><th>资产净值</th></#if>
            <#if header.ZFE == true><th>总份额(元)</th></#if>
            <#if header.DWJZ == true> <th>单位净值(元)</th></#if>
        </tr>
        <#list datas as data>
        <tr>
            <td>${data.dqrq?string("yyyy-MM-dd") }</td>
            <td style="max-width: 250px;">${data.cpmc }</td>
            <#if header.ZZC == true> <td><#if data.zzc??>${data.zzc?c}</#if></td>  </#if>
            <#if header.ZFZ == true> <td><#if data.zfz??>${data.zfz?c}</#if></td>  </#if>
            <#if header.ZCJZ == true> <td>${data.zcjz!'' ?c}</td>  </#if>
            <#if header.ZFE == true> <td>${data.zfe?if_exists}</td>  </#if>
            <#if header.DWJZ == true> <td>${data.dwjz?if_exists}</td>  </#if>
        </tr>
        </#list>
    </table>
</body>

</html>
