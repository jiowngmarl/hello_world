<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
  </head>
  <body>
        <table>
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="header" />
        </td>
      </tr>
      <tr>
        <td>
          <tiles:insertAttribute name="menu" />
        </td>
        <td>
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
    </table>
  </body>
</html>