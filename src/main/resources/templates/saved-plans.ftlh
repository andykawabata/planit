<!DOCTYPE html>
<html class="no-js" lang="">
<#include "/includes/head.ftlh">
<#include "/includes/preloader.ftlh">
<#include "/includes/header-nonindex.ftlh">

        <!--[if lte IE 9]>
          <p class="browserupgrade">
            You are using an <strong>outdated</strong> browser. Please
            <a href="https://browsehappy.com/">upgrade your browser</a> to improve
            your experience and security.
          </p>
        <![endif]-->

            <!-- ========================= hero-5 start ========================= -->

            <div class="hero-section hero-style-5 img-bg" style="background-image: url('/assets/img/hero/hero-5/hero-bg.svg'); padding: 120px 0 50px">
                <div class="container">
                    
                    <div class="row">
                    <div class="col-lg-8 modal-dialog" style="max-width: 800px">
                            <div class="modal-content rounded-6">
                             <div class="hero-content-wrapper modal-body p-4">
                             <p>
                             <#if user??>
                             <h6>Plans by ${user.userName}</h6>
                             <br>
                             	<ul>
                             		<#list plans as plan>
                             			<li>
                                                    <a href="/user/single-plan?planId=${plan.planId}">
                                                        <span style="display: inline-block; width: 250px">${plan.restaurantInfo.restaurantName}</span> | <#if plan.rating != 0> Rating: ${plan.rating} <#else> Not Rated </#if>
                                                    </a>
                                                </li>
                                                <hr>
                             	   	<#else>
                             		No plans
                             		</#list>
                             	</ul>
                             
                             <#else>
                             	Please <a class="page-scroll" href="<@spring.url '/oauth2/authorization/google'/>">login</a> to see your saved plans!
                             </#if>
                             </p>
                 			    </div>
                           </div>
                        </div>                        
                    </div>
                </div>
            </div>
            <!-- ========================= hero-5 end ========================= -->

    </section>
        <!-- ========================= hero-section-wrapper-6 end ========================= -->
<#include "/includes/footer.ftlh">
</body>
</html>