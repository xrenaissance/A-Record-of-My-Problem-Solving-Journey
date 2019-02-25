class Solution(object):
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        uniq_emails = set()
        for email in emails:
            addr, domain = email.split("@")
            addr = addr.replace(".", "")
            if "+" in addr:
                addr = addr[:addr.index("+")]
            uniq_emails.add(addr + "@" + domain)
        return len(uniq_emails)
